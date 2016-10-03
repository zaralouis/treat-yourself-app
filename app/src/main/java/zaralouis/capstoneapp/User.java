package zaralouis.capstoneapp;

/**
 * Created by zaralouis on 4/17/16.
 */
public class User
{
    private String name;
    private String password;
    private String email_address;

    public User(String name, String password, String email_address)
    {
        this.name = name;
        this.password = password;
        this.email_address = email_address;

    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmailAddress()
    {
        return email_address;
    }



}
