package box2d;

import enums.UserDataType;

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}