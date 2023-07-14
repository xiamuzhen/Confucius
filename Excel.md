### 从一个文本字符串的最后一个字符(\\)开始返回指定个数的字符

```
=IFERROR(RIGHT(A1,LEN(A1)-FIND("@",SUBSTITUTE(A1,"\","@",LEN(A1)-LEN(SUBSTITUTE(A1,"\",""))))),A1)
```
