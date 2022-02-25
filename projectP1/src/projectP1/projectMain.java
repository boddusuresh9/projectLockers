package projectP1;
import java.io.File;
import java.util.Scanner;

public class projectMain {

	public static void main(String[] args) {
		
		int a=1;
		System.out.println("Company           : Lockers pvt Ltd");
		System.out.println("Developer details : Boddu Suresh");
		System.out.println("                    Simplilearn student");
		while(a==1) {
		file filelist=new file();
		Scanner sc=new Scanner(System.in);
		String Path="c:\\Lockers";
		
		System.out.println("\n\nChoose an option :");
		System.out.println("***********************");
		System.out.println("1:Display all files");
		System.out.println("2:create a new file");
		System.out.println("3:Delete file");
		System.out.println("4:Search file");
		System.out.println("5:to exit application");
		File f=new File(Path);
		f.mkdir();
		char choice='0';
		System.out.println("\nEnter choice :");
		choice=sc.next().charAt(0);
		if(choice=='1') {
			String filesL[]=f.list();
			if(filesL.length==0) {
				System.out.println("\nNo files to display.");
			}
			else {
			for(int i=0;i<filesL.length;i++) {
				filelist.addFile(filesL[i]);
			}
			filelist.sortList();
			filelist.displayList();
			}
		
		}
		else if(choice=='2') {
			System.out.println("\nEnter file name to create a file : ");
			Scanner sc1=new Scanner(System.in);
			String newName=sc1.nextLine();
			filelist.addFile(newName);
			
			Path=Path+"/"+newName;
			File f1=new File(Path);
			try {
				if(f1.createNewFile()) {
					System.out.println("File created");
				}
				else {
					System.out.println("File already existing in current directory");
				}
			}
			catch(Exception ex){
				System.out.println("File not created");	
			}
			
		}
		else if(choice=='3') {
			System.out.println("\nEnter file name to delete a file : ");
			Scanner sc1=new Scanner(System.in);
			String newName=sc1.nextLine();
			filelist.deleteFile(newName);
			
			Path=Path+"/"+newName;
			File f1=new File(Path);
			try {
				if(f1.delete()) {
					System.out.println("File deleted");
				}
				else {
					System.out.println("FNF - File not found");
				}	
		}
			catch(Exception ex){
				System.out.println("File not deleted try again");	
			}
			
		}
		else if(choice=='4') {
			System.out.println("\nEnter file name to search :");
			Scanner sc2=new Scanner(System.in);
			String Searchfile=sc2.nextLine();
			String filesL1[]=f.list();
			
			if(filesL1.length==0) {
				System.out.println("\nNo files to display.");
			}
			else {
				int flag=0;
				for(int i=0;i<filesL1.length;i++) {
					if(filesL1[i]==Searchfile) {
						flag=1;
						System.out.println(Searchfile+" file is available.");
					}
				}
				if(flag==0) {
					System.out.println(Searchfile+" file is not available");
				}
			}
			
		}
			else if(choice=='5') {
				sc.close();
				a=0;
	}
			else {
				System.out.println("please choose a right option from the menu. Thank you!");
			}

}
}
}
