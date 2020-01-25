#include <jni.h>
#include <conio.h>
#include "JavaProg_TestSound.h"

JNIEXPORT jchar JNICALL Java_JavaProg_TestSound_getKey(JNIEnv *env, jobject object){
	return getch();
}