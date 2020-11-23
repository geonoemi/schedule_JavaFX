package sample;

import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public abstract class Line {

    protected String lineNum;
    protected boolean articulate;
    protected boolean lowFloor;
    protected double operationCost;
    protected int numOfSeats;
    protected boolean bicycleTransportOpp;
    protected int numOfDisabledPlaces;
    protected boolean needToRepair;
    protected String typeOfFuel;
    protected boolean hasWheel;
    protected String typeOfVehicle;

    protected static ArrayList<String> lineNums=new ArrayList<>();
    protected static ArrayList<Boolean> isArticulate=new ArrayList<>();
    protected static ArrayList<Boolean> isLowFloor =new ArrayList<>();
    protected static ArrayList<Double> operationCosts=new ArrayList<>();
    protected static ArrayList<Integer> numberOfSeats =new ArrayList<>();
    protected static ArrayList<Boolean> hasBicycleTransportOpp =new ArrayList<>();
    protected static ArrayList<Integer> disabledPlaces =new ArrayList<>();
    protected static ArrayList<Boolean> needsToRepair =new ArrayList<>();
    protected static ArrayList<String> fuelTypes =new ArrayList<>();
    protected static ArrayList<Boolean> hasWheels =new ArrayList<>();
    protected static ArrayList<String> typeOfVehicles =new ArrayList<>();

    public Line(String lineNum, boolean articulate, boolean lowFloor, double operationCost, int numOfSeats,	boolean bicycleTransportOpp, int numOfDisabledPlaces,
                boolean needToRepair,String typeOfFuel,	boolean hasWheel, String typeOfVehicle) {

        this.lineNum=lineNum;
        this.articulate=articulate;
        this.lowFloor=lowFloor;
        this.operationCost=operationCost;
        this.numOfSeats=numOfSeats;
        this.bicycleTransportOpp=bicycleTransportOpp;
        this.numOfDisabledPlaces=numOfDisabledPlaces;
        this.needToRepair=needToRepair;
        this.typeOfFuel=typeOfFuel;
        this.hasWheel=hasWheel;
        this.typeOfVehicle=typeOfVehicle;
    }

    public  String toString() {

        return lineNum+" "+articulate+" "+ lowFloor+" "+  operationCost +" "+numOfSeats+" "+	bicycleTransportOpp+" "+numOfDisabledPlaces
                +" "+needToRepair+" "+typeOfFuel+" "+hasWheel+" "+typeOfVehicle;
    }

}






