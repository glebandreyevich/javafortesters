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
        String Photo) {
    public ContactData() {
        this(" ", "", "", " ");
    }
    public ContactData withFirstName(String firstName){
        return new ContactData(this.id,firstName,this.lastName, this.Photo);
    }
    public ContactData withLastName(String lastName){
        return new ContactData(this.id,this.firstName,lastName, this.Photo);
    }
    public ContactData withId(String id){
        return new ContactData(id ,this.firstName,this.lastName, this.Photo);
    }
    public ContactData withPhoto(String Photo){
        return new ContactData(this.id ,this.firstName,this.lastName, Photo);
    }




}
