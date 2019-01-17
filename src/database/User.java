package database;
//our abstract class for users
public abstract class User {

    private String ID;
    private int password;

    public void setID(String ID)
    {
        this.ID=ID;
    }
    public void setPassword(int password) {
        password=password;
    }
    public String getID() {
        return ID;
    }
    public int getPassword()
    {
        return password;
    }
    public User() {

    }
    public User(String ID,int password)
    {
        this.ID=ID;
        this.password=password;
    }
    public abstract void GetInfo();
    
   
    /*
    public int SignIn(String ID, int password){
        return 0;
    }
    public boolean Login(String ID, int password){
        return true;
    }
    public void Delete(String ID,int password){}
    public void Update(String ID,int password){}
    */
}