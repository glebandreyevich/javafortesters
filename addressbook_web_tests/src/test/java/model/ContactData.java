package model;


public record ContactData(

        String id,
        String firstName,
        String lastName,
        //String company,
        //String title,
        // String website,
        //String address2,
        //String phone2,
        //String notes,
        //String middlename,
        //String nickname,
        //String photo,
        // String anniversaryDay,
        //String anniversaryMonth,
        //String anniversaryYear,
        //String birthdayDay,
        //String birthdayMonth,
        //String birthdayYear
        String Photo,
        String home,
        String mobile,
        String work,
        String phone2) {
    public ContactData() {
        this(" ", "", "", " ", "", "", "", "");
    }
    public ContactData withFirstName(String firstName){
        return new ContactData(this.id,firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withLastName(String lastName){
        return new ContactData(this.id,this.firstName,lastName, this.Photo, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withId(String id){
        return new ContactData(id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withPhoto(String Photo){
        return new ContactData(this.id ,this.firstName,this.lastName, Photo, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withHome(String home){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, home, this.mobile, this.work, this.phone2);
    }
    public ContactData withMobile(String mobile){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, mobile, this.work, this.phone2);
    }
    public ContactData withWork(String work){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, work, this.phone2);
    }
    public ContactData withPhone2(String phone2){
        return new ContactData(this.id ,this.firstName,this.lastName, this.Photo, this.home, this.mobile, this.work, phone2);
    }




}
