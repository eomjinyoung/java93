#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
  int i = 10;
  int* p = (int*)malloc(12);
  p[0] = 100;
  p[1] = 200;
  p[2] = 300;
  printf("%d, %d, %d\n", *(p + 0), p[1], *(p + 2));
  free(p);

  p[0] = 100;
  p[1] = 200;
  p[2] = 300;
  
  char* p2 = (char*)malloc(300);
  printf("%d, %d, %d, %d\n", *(p + 0), p[1], *(p + 2), p[3]);
  

}
