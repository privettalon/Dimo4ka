package datamodels;

import pages.UserDataFaker;

public class UserDataModelConstructor {
    public static UserDataModel.UserDataModelBuilder getRegistrationData(){
        return UserDataModel.builder()
                .username(new UserDataFaker().firstName())
                .password(new UserDataFaker().emailAddress());
    }
}
