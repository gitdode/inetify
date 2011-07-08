package net.luniks.android.inetify;

import android.database.Cursor;
import android.location.Location;

/**
 * Interface for a database adapter, basically a helper for the SQLite database.
 * 
 * @author torsten.roemer@luniks.net
 */
public interface DatabaseAdapter {

	/**
	 * Adds the given BSSID and SSID as ignored Wifi network to the database.
	 * If an entry with the same BSSID exists it will be replaced.
	 * @param bssid
	 * @param ssid
	 * @return boolean true if successfully added, false otherwise
	 */
	boolean addIgnoredWifi(String bssid, String ssid);
	
	/**
	 * Returns true if the given SSID is an ignored Wifi network, false otherwise. 
	 * @param ssid
	 * @return boolean true if ignored, false otherwise
	 */
	boolean isIgnoredWifi(String ssid);
	
	/**
	 * Deletes the entrie(s) matching the given SSID as ignored Wifi networks from the database.
	 * @param ssid
	 * @return boolean true if one or more entries deleted, false otherwise
	 */
	boolean deleteIgnoredWifi(String ssid);
	
	/**
	 * Returns a cursor to all ignored Wifi networks in the database.
	 * @return Cursor all ignored Wifi networks
	 */
	Cursor fetchIgnoredWifis();
	
    /**
     * Adds the given Wifi identified by the given BSSID together with its SSID and location
     * to the database.
     * @param bssid
     * @param ssid
     * @param location
     * @return boolean true if successfully added, false otherwise
     */
	boolean addLocation(final String bssid, final String ssid, final Location location);

	/**
	 * Looks for a Wifi network in the database that is near the given location
	 * and if it finds one, returns its SSID.
	 * @param location
	 * @return String the SSID if the first Wifi found
	 */
	String findWifi(final Location location);

	/**
	 * Deletes the location of the Wifi identified by the given BSSID.
	 * @param bssid
	 * @return boolean true if one or more entries deleted, false otherwise
	 */
	boolean deleteLocation(final String bssid);

	/**
	 * Returns a cursor to all Wifi locations in the database.
	 * @return Cursor all Wifi locations
	 */
	public Cursor fetchLocations();
	
	/**
	 * Effectively closes the database.
	 */
	void close();
	
	/**
	 * Returns true if the database is open, false otherwise.
	 * @return boolean true if the database is open, false otherwise
	 */
	boolean isOpen();
	
    /**
     * Returns the version of the database.
     * @return int database version
     */
    int getDatabaseVersion();
	
}
