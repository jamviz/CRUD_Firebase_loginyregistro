package com.example.parcial_jamir_balcona;
import android.os.Parcel;
import android.os.Parcelable;

public class HelperClass implements Parcelable {

    String name, DNI, username, password, edad, nacimiento;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }


    public HelperClass(String name, String dni, String username, String password, String edad, String nacimiento) {
        this.name = name;
        this.DNI = dni;
        this.username = username;
        this.password = password;
        this.edad = edad;
        this.nacimiento = nacimiento;
    }


    // Constructor para la clase Parcelable
    protected HelperClass(Parcel in) {
        name = in.readString();
        DNI = in.readString();
        username = in.readString();
        password = in.readString();
        edad = in.readString();
        nacimiento = in.readString();
    }

    // Métodos para la clase Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(DNI);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(edad);
        dest.writeString(nacimiento);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HelperClass> CREATOR = new Creator<HelperClass>() {
        @Override
        public HelperClass createFromParcel(Parcel in) {
            return new HelperClass(in);
        }

        @Override
        public HelperClass[] newArray(int size) {
            return new HelperClass[size];
        }
    };

    public HelperClass() {
    }
}
