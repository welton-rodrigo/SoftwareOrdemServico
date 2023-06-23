package br.com.wrs.jdbc.teste;


	public class Gerador {
	
		public static void main(String[] args){
			String[] carct ={"0","1","2","3","4","5","6","7","8","9","#"};

		    String senha="";

		    for(int y=0; y<100; y++){
		    for (int x=0; x<6; x++){
		        int j = (int) (Math.random()*carct.length);
		        senha += carct[j];  
			}
		    System.out.println(senha);
		    senha = "";
		    }
	

    
}

}
	
