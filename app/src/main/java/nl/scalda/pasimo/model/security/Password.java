package nl.scalda.pasimo.model.security;

import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;

/**
	  * Original Author: Ian Gallagher <igallagher@securityinnovation.com>
	  * Current Author: Collin Knuit
	  * From https://github.com/defuse/password-hashing
	  * This code utilizes jBCrypt, which you need installed to use.
	  * jBCrypt: http://www.mindrot.org/projects/jBCrypt/
	  */

	public class Password {
	  	// Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
		private static final int workload = 12;
		private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		private static SecureRandom rnd = new SecureRandom();

		/**
		 * This method can be used to generate a string representing an account password
		 * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
		 * hash string of length=60
		 * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
		 * A workload of 12 is a very reasonable safe default as of 2013.
		 * This automatically handles secure 128-bit salt generation and storage within the hash.
		 * @param password_plaintext The account's plaintext password as provided during account creation,
		 *			     or when changing an account's password.
		 * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
		 */
		public static String hashPassword(String password_plaintext) {
			String salt = BCrypt.gensalt(workload);
			String hashed_password = BCrypt.hashpw(password_plaintext, salt);

			return(hashed_password);
		}

		/**
		 * This method can be used to verify a computed hash from a plaintext (e.g. during a login
		 * request) with that of a stored hash from a database. The password hash from the database
		 * must be passed as the second variable.
		 * @param password_plaintext The account's plaintext password, as provided during a login request
		 * @param stored_hash The account's stored password hash, retrieved from the authorization database
		 * @return boolean - true if the password matches the password of the stored hash, false otherwise
		 */
		public static boolean checkPassword(String password_plaintext, String stored_hash) {
			boolean password_verified = false;

			if(null == stored_hash || !stored_hash.startsWith("$2a$"))
				throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

			password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

			return(password_verified);
		}
		
		/**
		 * This method can be used to generate a string representing an account password
		 * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
		 * hash string of length=60
		 * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
		 * A workload of 12 is a very reasonable safe default as of 2013.
		 * This automatically handles secure 128-bit salt generation and storage within the hash.
		 * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
		 */
		public static String[] forgotPassword (){
			String salt = BCrypt.gensalt(workload);
			String randomString = Password.randomString();
			String hashed_password = BCrypt.hashpw(randomString, salt);
			return( new String[]{hashed_password, randomString});
		}
		
		//https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
		public static String randomString(){
			   StringBuilder sb = new StringBuilder( 8 );
			   for( int i = 0; i < 8; i++ ) 
			      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
			   return sb.toString();
			}
}
