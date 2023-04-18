package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double distancia (Geo geo2) {
        double r = 6371; 
        double lat1 = Math.toRadians(latitude);
        double lon1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(geo2.latitude);
        double lon2 = Math.toRadians(geo2.longitude);
        double difLat = lat2 - lat1;
        double difLon = lon2 - lon1;
        double a = Math.sin(difLat / 2) * Math.sin(difLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(difLon / 2) * Math.sin(difLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return r * c; //distância em metros
    }

	public double distanciaDoPonto(Geo geo){
		return distancia(geo);
	}

	@Override
	public String toString(){
		return String.format("latitude %.3f \t longitude %.3f",latitude, longitude);
	}
}
