package ua.goit.petstore.controller;

public final class EndPoints {
    public static final String HOST = "https://petstore.swagger.io/v2/";
    public static final String PET = "pet";
    public static final String PET_BY_ID = PET+"/{petId}";
    public static final String UPLOAD_IMAGE_BY_ID = PET_BY_ID +"/uploadImage";
    public static final String FIND_PET_BY_STATUS = PET+"/findByStatus";
    public static final String STORE_INVENTORY = "store/inventory";
    public static final String STORE_ORDER = "store/order";
    public static final String STORE_ORDER_WITH_ID = STORE_ORDER+"/{orderId}";
    public static final String USER_END_POINT = "user";
    public static final String CREATE_USERS_WITH_LIST = USER_END_POINT+"/createWithList";
    public static final String CREATE_USERS_WITH_ARRAY = USER_END_POINT+"/createWithArray";
    public static final String USERNAME_ENDPOINT = USER_END_POINT+"/{username}";
    public static final String USER_LOGIN = USER_END_POINT+"/login";
    public static final String USER_LOGOUT = USER_END_POINT+"/logout";
    public static final String HEADERS = "Content-Type: application/json";
}
