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
	public static String Get_URL=Base_URL + "/user/{UserName}" ;
	public static String Put_URL=Base_URL+"/user/{UserName}";
	public static String Delete_URL=Base_URL+"/user/{UserName}";
	
	// Store Model
	
	
	
	// Pet Model
	
	
}
