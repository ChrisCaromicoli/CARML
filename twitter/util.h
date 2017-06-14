#pragma once //A preprocesssor directive, source file only included once in single compilation

namespace util { //A namespace is use dto structure into logical units, all functions to fulfill a certain goal

const float fltmax = numeric_limits<float>::max(); //looks like its creating an array of float values

//looks like function that converts strings to lower case
inline string tolower(string s) { //inline suggests compiler substitute the body of the function inline, inserts function code at address of each function call to save overhead of function call
    transform(s.begin(), s.end(), s.begin(), [=](char c){return std::tolower(c);}); //lambda function, essentially goes through string starting at beginning going to end, each charachter assigned to c and made lower case
    return s; //returns transformed string
}
//Creates enum class split, consists of user-defined constants called enumerators
enum class Split {
    KeepDelimiter,
    RemoveDelimiter,
    OnlyDelimiter
};
//auto keyword declares a varoable in the automatic storage class
auto split = [](string s, string d, Split m = Split::KeepDelimiter){
    regex delim(d); //regex-regular expressions, standardzed way to express patterns to be matched against sequences of characters
    //splitting the string
    cregex_token_iterator cursor(&s[0], &s[0] + s.size(), delim, m == Split::KeepDelimiter ? initializer_list<int>({-1, 0}) : (m == Split::RemoveDelimiter ? initializer_list<int>({-1}) : initializer_list<int>({0})));
    cregex_token_iterator end;
    vector<string> splits(cursor, end);
    return splits;
};
//getting time
inline string utctextfrom(seconds time) {
    stringstream buffer;
    time_t tb = time.count(); //sets refernce time
    struct tm* tmb = gmtime(&tb);   //formats time to GMT timeezone (We will likely want to change this to eastern time)
    buffer << put_time(tmb, "%a %b %d %H:%M:%S %Y"); //formatting time and putting in buffer
    return buffer.str(); //returning buffer as string
}
//returns duration object with time span between epoch and time point
inline string utctextfrom(system_clock::time_point time = system_clock::now()) {
    return utctextfrom(time_point_cast<seconds>(time).time_since_epoch());
}
//I bleieve this function referecnes the ignore elements property and essentially returns the strings of interest
inline function<observable<string>(observable<long>)> stringandignore() {
    return [](observable<long> s){
        return s.map([](long){return string{};}).ignore_elements();
    };
}
//Template allows for generic functions and classes
template <class To, class Rep, class Period>
To floor(const duration<Rep, Period>& d) //rounds duration
{
    To t = std::chrono::duration_cast<To>(d); //unsure..
    if (t > d)
        return t - To{1};
    return t;
}

}
