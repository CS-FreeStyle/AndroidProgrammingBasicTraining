#Activity数据回传

> Android提供了一个startActivityForResult()方法，来实现回传数据
> ```Java
Intent intent = new Intent(this,Activity02.class);
startActivityForResult();
``` 
startActivityForResult()方法接受两个参数，第一个参数是Intent,  
第二个参数是请求码，用于判断数据的来源。 

> 接下来是在Activity02中的添加数据返回的示例代码：
``` Java
Intent intent = new Intent();
intent.putExtra("extra_data","Hello_Activity01");
setResult(1,intent);
finish();
``` 

> 上述代码，实现了回传数据的功能，其中，setResult()方法接受两个参数，  
第一个参数resultCode结果码，一般使用0或者1；第二个参数则是把带有数据  
的Intent传递回去，最后调用finish()方法销毁当前Activity.

> 由于使用了startActivityForResult()方法启动Activity02，因此会在  
Activity01页面回调onActivityResult()方法，需要在Activity01中重写  
该方法来获取返回的数据，具体的代码如下所示： 

```Java
protected void onActivityResult(int requestCode,int resultCode,Intent data){
  super.onActivityResult(requestCode,resultCode,data);
  if(resultCode ==1){
    String mData = data.getStringExtra("extra_data");
    Log.i("Activity01",mData);
  }
}
``` 

> 上述代码实现了获取返回数据的功能。onActivityResult()方法接受三个参数,  
第一个参数requestCode，表示在启动Activity时传递的请求码；第二个参数是resultCode，  
表示在返回数据时传入结果码；第三个参数data,表示携带返回数据的Intent.

> 需要注意的是，在一个Activity中很有可能调用startActivityForResult()方法  
启动多个Activity,每一个Activity，每一个Activity返回的数据都会回调到onActivity()  
这个方法中，因此，首先要通过检查requestCode的值来判断数据来源，确定数据是从  
Activity02返回的，然后在通过resultCode的值来判断数据处理是否成功，最后从data中  
取出数据并打印，这样就完成了Activity中数据返回的功能。

