# shop
 
 1. Created ShopApplication.java for spring boot appliction start.
 2. created ShopController.java for restful service to service to rest clients
   it has two methods 1. add  - end point uri will be  : http://localhost:2001/shopAppend
   to add shop detiils
 3. Shop classs for shop detials including shop address 
 4. ShopService and ShopServiceImpl service for logic to append and connect to Google map to get the lat and lng details and store in Hashmap.
   a. addShop method of ShopServiceImpl to add shop and check and already existed and calling google.map to get details and set those to shop object and save to HashMap.
   b. When user give his lat,lng to application by using endpoint url : http://localhost:2001/shopSearch.
   it wil calculate in getShop method of ShopserviceImpl method and give it nearest shop to him.
   
 5. For Exception handing, Wrote controller ExceptionHandlerController.java  to hadling exception logic.
 
 
 request and response : 
 
 Adding shop :http://localhost:2001/shopAppend
 
 Request :
 
 {
	"shopName": "lidl",        
	"updatedBy": "B",
	"shopAddress": {
		"number": 144,
		"postCode": "80804",
		"address" : "Leopoldstrasse"

	}
  
 Response :
 {"message": "Shop is added."}
  
  
  
  
  
  
  Searching for nearest Shop :
    http://localhost:2001/shopSearch
  Request :
  
  {
	"lat":"48.16883680000001",
	"lng":"11.5874809"
}

Response :


{
    "shopName": "lidl",
    "shopAddress": {
        "number": 144,
        "postCode": "80804",
        "address": "Leopoldstraße 144, 80804 München, Germany"
    },
    "message": null,
    "updatedBy": "B",
    "lat": 48.16883680000001,
    "lng": 11.5874809
}
