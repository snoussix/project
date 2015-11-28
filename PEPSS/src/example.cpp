#include <jni.h> 
#include <stdio.h> 
#include "TestJNI1.h" 

JNIEXPORT void JNICALL Java_com_sdzee_pricing_compute_computePrices (JNIEnv *, jobject)
{ 
  printf(" Bonjour\n "); 
  return; 
}
