import java.util.Objects;

public class Contacts {
    String f_name;
    String l_name;
    String address;
    String city;
    String state;
    int zip;
    int phn_no;
    String email;

    public Contacts(String f_name, String l_name, String address, String city, String state, int zip, int phn_no, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phn_no = phn_no;
        this.email = email;
    }


    public String getFirstName() {return f_name;}
    public String getlastName() {return l_name;}
    public String getcity() {return city;}
    public String getstate() {return state;}
    public String getemail() {return email;}
    public int getPhonenumber() {return phn_no;}
    public int zip() {return zip;}
    public void setFirstname(String next) {this.f_name=next;}
    public void setLastname(String next) {this.l_name=next;}
    public void setCity(String next) {this.city=next;}
    public void setState(String next) {this.state=next;}
    public void setEmail(String next) {this.email=next;}
    public void setPhone(int i) {this.phn_no=i;}
    public void setZip(int i) {this.zip=i;}
    public String toString() {return "["+f_name+" "+l_name+" " +address+" "+city+" "+state+" "+zip+" "+phn_no+" "+email+"]";}


    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Contacts c=(Contacts) obj;
        return f_name.equals(c.f_name) &&
                l_name.equals(c.l_name);
    }


    public int hashCode(){
        return Objects.hash(f_name,l_name,address,city,state,zip,phn_no,email);
    }


}
