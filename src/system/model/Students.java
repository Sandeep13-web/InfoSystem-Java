package system.model;

public class Students {
    private int id;
    
    private String uid;
    
    private String name;
    
    private String contact;
    
    private String address;
    
    private String email;
    
    private String programme;
    
    private String batch;
    
    private String semester;
    
    public Students(){
    }
    
    public Students(int id, String uid, String name, String contact, String address, String email, String programme, String batch, String semester){
        
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.programme = programme;
        this.batch = batch;
        this.semester = semester;
        
    }
    
    public Students(String uid, String name, String contact, String address, String email, String programme, String batch, String semester){
        this.uid = uid;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.programme = programme;
        this.batch = batch;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
}
