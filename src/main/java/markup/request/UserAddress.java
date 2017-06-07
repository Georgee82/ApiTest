package markup.request;
	public class UserAddress {
		private String country;
		private String city;
		private String state;
		private String zip;
		private String street;

		public void setCountry(String country) {
			this.country = country;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public void setState(String state) {
			this.state = state;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCountry() {
			return country;
		}

		public String getCity() {
			return city;
		}

		public String getState() {
			return state;
		}

		public String getZip() {
			return zip;
		}

		public String getStreet() {
			return street;
		}

		
	}