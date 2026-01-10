public class User {
    private String userName;
    private Task [] taskArray=new Task[10];
    public User(String userName){
        this.userName=userName;
    }
    public Task [] getTaskArray(){
        return taskArray;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}