package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de Entrada: ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de Saida: ");
			Date dataSaida = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com as datas de atualização da reserva:");
			System.out.print("Data de Entrada: ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de Saida: ");
			dataSaida = sdf.parse(sc.next());

			reserva.atualizaData(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato invalido para DATA!");
		}catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Um erro inesperado ocorreu!");
		}

		sc.close();
	}

}
