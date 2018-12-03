package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) throws DomainException {
		if (!dataSaida.after(dataEntrada)) {
			 throw new DomainException("A data de saida deve ser depois da data de entrada!");
		 }
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}
	
	public long duracao() {
		long diff = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public void atualizaData(Date dataEntrada, Date dataSaida) throws DomainException  {
		 Date now = new Date();
		 if (dataEntrada.before(now) || dataSaida.before(now)) {
			 throw new DomainException("As datas de reservas devem ser preenchidas com datas futuras!");
		 }
		 if (!dataSaida.after(dataEntrada)) {
			 throw new DomainException("A data de saida deve ser depois da data de entrada!");
		 }
		 this.dataEntrada = dataEntrada;
		 this.dataSaida = dataSaida;
			
	}
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", Data de Entrada: "
			+ sdf.format(dataEntrada)
			+ ", Data de Saida: "
			+ sdf.format(dataSaida)	
			+ ", "
			+ duracao()
			+ " Noites";
	}
}
