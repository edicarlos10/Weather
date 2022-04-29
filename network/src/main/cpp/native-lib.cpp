// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("network");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("network")
//      }
//    }
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_weather_weatherForecast_fragment_WeatherForecastCityFragment_stringFromJNI(
        JNIEnv *env, jobject thiz) {
    std::string apiKey = "58611e500e6bfe3dd41851e99a88a932";
    return env->NewStringUTF(apiKey.c_str());
}