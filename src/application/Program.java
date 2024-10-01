package application;

import entities.Services;
import util.Taxes;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean program = true;
		int quantity = 0;
		
		while(program == true){
		
			System.out.println("Quantos serviços/produtos deseja cadastrar?");
			quantity = sc.nextInt();
			sc.nextLine();
			
			while(quantity > 0) {
			
				double finalAmount = 0;
				double tax = 0;
				
				System.out.println("------------");
				System.out.println("Digite o custo do serviço n°" + quantity);
				double coust = sc.nextDouble();
				System.out.println("Digite a margem de lucro");
				double profitMargin = sc.nextDouble();
				
				Services service1 = new Services(coust,profitMargin);
				System.out.println("Serviço cadastrado com sucesso!");
		
				System.out.println("Selecione o imposto para o cálculo:"
						+ "\n1 - IPI"
						+ "\n2 - ICMS"
						+ "\n3 - ISS");
				
				int op = sc.nextInt();
				sc.nextLine();
				
				switch(op) {
				
					case 1:
						System.out.println("Para cálculo do IPI, precisa-se também informar o frete e o seguro!");
						System.out.println("Digite o valor do seguro:");
						double security = sc.nextDouble();
						System.out.println("Digite o valor do frete");
						double freight = sc.nextDouble();
						
						tax = Taxes.ipi(service1.getCoust(), freight, security);
						finalAmount = service1.getFinalAmount();
				
						break;
						
					case 2:
						
						System.out.println("Para cálculo do ICMS, precisa-se também informar a aliquota da UF_Origem para UF_destino!");
						System.out.println("Informe a alíquota %:");
						double aliquot = sc.nextDouble();
						
						tax = Taxes.icms(service1.getCoust(),aliquot);
						finalAmount = service1.getFinalAmount();
						
						break;
						
					case 3:
						System.out.println("Para cálculo do ISS, precisa-se também informar a aliquota praticada");
						System.out.println("Informe a alíquota %:");
						double taxRateApplied = sc.nextDouble();
						
						tax = Taxes.iss(taxRateApplied, service1.getCoust());
						finalAmount = service1.getFinalAmount();
						
						break;
				}
				
				
				System.out.println("+++Cálculo+++\nO valor final do serviço:"
				+ finalAmount);
				
				quantity--;
			}
			
			System.out.println("Deseja encerrar a aplicação S N");
			sc.nextLine();
			char resp = sc.next().charAt(0);
			if(resp == 'S' || resp == 's') {
				program = false;
			}
		}
		
		System.out.println("Programa finalizado.");
	}
}
