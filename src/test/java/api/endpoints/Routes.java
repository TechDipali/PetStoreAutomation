package api.endpoints;

/*
 Swagger URI- https://petstore.swagger.io/v2/swagger.json
 
 Create User- https://petstore.swagger.io/v2/user
 Get User- https://petstore.swagger.io/v2/user/{UserName}
 Update User- https://petstore.swagger.io/v2/user/{UserName}
 Delete User- https://petstore.swagger.io/v2/user/{UserName}
 
 */


public class Routes {
	
	public static String Base_URL="https://petstore.swagger.io/v2";
	
	// User Model
	
	public static String post_URL=Base_URL+"/user";
	public static String get_URL=Base_URL + "/user/{UserName}" ;
	public static String put_URL=Base_URL+"/user/{UserName}";
	public static String delete_URL=Base_URL+"/user/{UserName}";
	
	// Store Model
	
	public static String storePost_URL=Base_URL+"/store/order";
	public static String storeGet_URL=Base_URL + "/store/order/{orderId}" ;
	public static String storeDelete_URL=Base_URL+"/store/order/{orderId}";
	
	// Pet Model
	
	public static String petPost_URL=Base_URL+"/pet";
	public static String petGet_URL=Base_URL + "/pet/{findByStatus}" ;
	public static String petPut_URL=Base_URL+"/pet";
	
	
	
}
