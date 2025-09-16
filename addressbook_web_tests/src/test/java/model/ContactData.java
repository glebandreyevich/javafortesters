package model;


public record ContactData(

        String id,
        String firstName,
        String lastName,
        String Photo,
        String home,
        String mobile,
        String work,
        String phone2, String email, String email2, String email3, String address) {
    public ContactData() {
        this(" ", "", "", " ", "", "", "", "", "", "", "","");
    }
    public ContactData withFirstName(String firstName){
        return new ContactData(this.id,firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withLastName(String lastName){
        return new ContactData(this.id,this.firstName,lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withId(String id){
        return new ContactData(id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withPhoto(String Photo){
        return new ContactData(this.id ,this.firstName,this.lastName, Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withHome(String home){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withMobile(String mobile){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, mobile, this.work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withWork(String work){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, work, this.phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withPhone2(String phone2){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, phone2, this.email, this.email2, this.email3, this.address);
    }
    public ContactData withEmail(String email){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, email, this.email2, this.email3, this.address);
    }
    public ContactData withEmail2(String email2){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, email2, this.email3, this.address);
    }
    public ContactData withEmail3(String email3){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, email3, this.address);
    }
    public ContactData withAddress(String address){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2, this.email, this.email2, this.email3, address);
    }





}
