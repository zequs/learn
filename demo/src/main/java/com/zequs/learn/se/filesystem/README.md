####1.read和write在执行时会阻塞直至字节被读入或写出，这意味着流不能被立即访问，那么当前线程将会被阻塞。available方法使我们可以去检查当前可读入的字节数量，意味我们判断输入流是否有字节，有的话再进行读取。这样就不会进入阻塞状态
```
int bytesAvailable = in.available();
if (bytesAvailable > 0) {
   byte[] data = new byte[bytesAvailable];
   in.read(data);
}
```