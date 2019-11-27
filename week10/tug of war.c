#include <stdio.h>
static char c[45000][101], hs[45000][101];
static int n, cp[45000], in[101]; // inp를 in으로 변경 (특별한 의미 없음)
static double sum, sumd2, sol;
static char isAllEquals;
void input(void){
    int i, j;
    scanf("%d", &n);
    for(i = 0; i < n; i++)
        scanf("%d", &in[i]);

    // 모든 입력 체중들이 같은지 검사
    isAllEquals = 1;
    for(i = 1; i < n; i++)
        if(in[0] != in[i])
            isAllEquals = 0;    

    for(i = 0; i < 45000; i++)
        for(j = 0; j < n; j++)
            c[i][j] = hs[i][j] = 0;

    for(i = 0; i < 45000; i++)
        cp[i] = 0;
} 
double myabs(double a){
    if(a < 0)
        return -a;
    else
        return a;
}

void dynamic(void){
    int i, j, k, l;
    int sw;

    sum = 0;
    for(i = 0; i < n; i++)
        sum = sum + (double)in[i];
    sumd2 = sum / (double)2.0;
    
    sol = sumd2;
    cp[0] = 1;
	 if(isAllEquals == 0){
        for(i = 0; i <= sumd2; i++)
            for(j = 0; j < cp[i]; j++)
                for(k = 0; k < n; k++){
                    if(i == in[k]) // 같은 수가 중복되는 경우는 continue
                        continue;
                    sw = 0; 
                    if(hs[i+in[k]][c[i][j] + 1] == 0)
                        sw = 1;
                    if(sw == 1 && c[i][j] < n/2){
                        hs[i + in[k]][c[i][j] + 1] = 1;
                        c[i+in[k]][cp[i+in[k]]] = c[i][j] + 1;
                        cp[i + in[k]]++;
                        if(c[i][j] + 1 == n/2 && myabs((i + in[k]) - sumd2) < sol)
                            sol = myabs((i + in[k]) - sumd2);
                    }
                }
    }
 else{ // 모든 체중이 같은 경우
        if(n % 2 == 1) // 홀수 명인 경우
            sol = in[0]/2.0;
        else // 짝수 명인 경우
            sol = 0;
    }
}

void main(){
    int i, t;

    scanf("%d", &t);
    for(i = 0; i < t; i++){
        input();
        dynamic();

        if(i > 0)
            printf("\n");
        printf("%d %d\n", (int)(sumd2 - sol), (int)(sumd2 + sol));
    }
}

