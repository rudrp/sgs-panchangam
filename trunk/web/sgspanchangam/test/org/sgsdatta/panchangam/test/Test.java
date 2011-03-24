package org.sgsdatta.panchangam.test;

import java.io.IOException;

import org.sgsdatta.panchangam.data.loader.PanchangamDataLoader;

public class Test {
	public static void main(String[] args) {
		PanchangamDataLoader dataLoader=new PanchangamDataLoader();
		try {
			dataLoader.loadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
