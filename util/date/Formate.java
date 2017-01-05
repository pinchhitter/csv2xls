package util.date;

import java.io.*;
import java.util.*;

class Formate{
	
	static String password(String date){
		String[] token = date.split("-");
		return token[2].trim()+""+token[1].trim()+""+token[0].trim();
	}

	static String formateDate(String date){
		String[] token = date.split("-");
		return token[2].trim()+"-"+token[1].trim()+"-"+token[0].trim();
	}

	public static void main(String[] args){

		try{
			Scanner scn = new Scanner(System.in);
			boolean header = true;
			String line = null;
			while( scn.hasNext() ){
				line = scn.nextLine();
				if( header ){
					System.out.println("session_date,session,applicant_name,email,Dob(YYYY-MM-DD),Dob(DD-MM-YYYY),registration_id, sorting_field, password, exam_center_id, tcs_center_code,Centre Name,Subject Code,Subject Name,PH(Yes/No),Type of PH,Scribe");
					header = false;
					continue;
				}

				String []token = line.split(",");

				for(int i = 0; i < token.length; i++){
					
					if(i == 0){
						System.out.print(token[i].trim());
					}else if( i == 4){
						System.out.print(","+token[4].trim()+","+ formateDate( token[4].trim() ) );
					}else if( i == 7 ){ 
						System.out.print(","+password( token[4].trim() ) );
					}else if ( i == 9){
						System.out.print(",");
					}else{
						System.out.print(","+token[i].trim());
					}
		
				}
				System.out.println();
			}


		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
