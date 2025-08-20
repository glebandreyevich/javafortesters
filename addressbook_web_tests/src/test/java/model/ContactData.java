package model;


public record ContactData(
        String firstName,
        String lastName,
        String address,
        String homePhone,
        String mobilePhone,
        String workPhone,
        String email,
        String email2,
        String email3,
        //String company,
        //String title,
        String fax
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
) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "");
    }

}
