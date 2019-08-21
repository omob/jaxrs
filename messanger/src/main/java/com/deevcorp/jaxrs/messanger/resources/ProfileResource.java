package com.deevcorp.jaxrs.messanger.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deevcorp.jaxrs.messanger.model.Profile;
import com.deevcorp.jaxrs.messanger.response.ResponseFormat;
import com.deevcorp.jaxrs.messanger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();

	public ProfileResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET 
    @Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
    	return this.profileService.getAllProfiles();
	}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
//    	ResponseFormat response = new ResponseFormat();
		
    	return this.profileService.getProfile(profileName);
//    	if (profile.equals(null)) {
//    		response.setData(null);
//    		response.setSuccess(true);
//    		
//    		return response;
//    	}
//    	
//    	response.setSuccess(true); 
//    	response.setData(profile);
//    	
//    	return response;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile (Profile profile) {
    	return this.profileService.addProfile(profile);	
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName,  Profile profile) {
    	profile.setProfileName(profileName);
    	return this.profileService.updateProfile(profile);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String profileName) {
    	return this.profileService.removeProfile(profileName);
    }
}
