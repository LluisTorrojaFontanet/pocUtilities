package ad.cass.poc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TramitDTO implements Serializable {

	private static final long serialVersionUID = 7047007879204242210L;
	
	private String numeroTramit;
	private String numeroTiquet;
	private String codiTramit;
	private String ultimEstat;
	private String numeroIdCASS;
	private String numeroIdCASS2;
	private String documentRelacionat;
	private LocalDate dataPagament;
	private BigDecimal quantitat;
	private BigDecimal importTramit;
	private String facturaTramit;
	private String usuariCreacio;
	private LocalDateTime dataHoraCreacio;
	private LocalDateTime dataHoraModificacio;
	private String usuariModificacio;

	private String nomIdCASS;
	private String nomIdCASS2;
	private LocalDate dataNaixementIdCASS;
	private LocalDate dataNaixementIdCASS2;
	/**
	 * @return the numeroTramit
	 */
	public String getNumeroTramit() {
		return numeroTramit;
	}
	/**
	 * @param numeroTramit the numeroTramit to set
	 */
	public void setNumeroTramit(String numeroTramit) {
		this.numeroTramit = numeroTramit;
	}
	/**
	 * @return the numeroTiquet
	 */
	public String getNumeroTiquet() {
		return numeroTiquet;
	}
	/**
	 * @param numeroTiquet the numeroTiquet to set
	 */
	public void setNumeroTiquet(String numeroTiquet) {
		this.numeroTiquet = numeroTiquet;
	}
	/**
	 * @return the codiTramit
	 */
	public String getCodiTramit() {
		return codiTramit;
	}
	/**
	 * @param codiTramit the codiTramit to set
	 */
	public void setCodiTramit(String codiTramit) {
		this.codiTramit = codiTramit;
	}
	/**
	 * @return the ultimEstat
	 */
	public String getUltimEstat() {
		return ultimEstat;
	}
	/**
	 * @param ultimEstat the ultimEstat to set
	 */
	public void setUltimEstat(String ultimEstat) {
		this.ultimEstat = ultimEstat;
	}
	/**
	 * @return the numeroIdCASS
	 */
	public String getNumeroIdCASS() {
		return numeroIdCASS;
	}
	/**
	 * @param numeroIdCASS the numeroIdCASS to set
	 */
	public void setNumeroIdCASS(String numeroIdCASS) {
		this.numeroIdCASS = numeroIdCASS;
	}
	/**
	 * @return the numeroIdCASS2
	 */
	public String getNumeroIdCASS2() {
		return numeroIdCASS2;
	}
	/**
	 * @param numeroIdCASS2 the numeroIdCASS2 to set
	 */
	public void setNumeroIdCASS2(String numeroIdCASS2) {
		this.numeroIdCASS2 = numeroIdCASS2;
	}
	/**
	 * @return the documentRelacionat
	 */
	public String getDocumentRelacionat() {
		return documentRelacionat;
	}
	/**
	 * @param documentRelacionat the documentRelacionat to set
	 */
	public void setDocumentRelacionat(String documentRelacionat) {
		this.documentRelacionat = documentRelacionat;
	}
	/**
	 * @return the dataPagament
	 */
	public LocalDate getDataPagament() {
		return dataPagament;
	}
	/**
	 * @param dataPagament the dataPagament to set
	 */
	public void setDataPagament(LocalDate dataPagament) {
		this.dataPagament = dataPagament;
	}
	/**
	 * @return the quantitat
	 */
	public BigDecimal getQuantitat() {
		return quantitat;
	}
	/**
	 * @param quantitat the quantitat to set
	 */
	public void setQuantitat(BigDecimal quantitat) {
		this.quantitat = quantitat;
	}
	/**
	 * @return the importTramit
	 */
	public BigDecimal getImportTramit() {
		return importTramit;
	}
	/**
	 * @param importTramit the importTramit to set
	 */
	public void setImportTramit(BigDecimal importTramit) {
		this.importTramit = importTramit;
	}
	/**
	 * @return the facturaTramit
	 */
	public String getFacturaTramit() {
		return facturaTramit;
	}
	/**
	 * @param facturaTramit the facturaTramit to set
	 */
	public void setFacturaTramit(String facturaTramit) {
		this.facturaTramit = facturaTramit;
	}
	/**
	 * @return the usuariCreacio
	 */
	public String getUsuariCreacio() {
		return usuariCreacio;
	}
	/**
	 * @param usuariCreacio the usuariCreacio to set
	 */
	public void setUsuariCreacio(String usuariCreacio) {
		this.usuariCreacio = usuariCreacio;
	}
	/**
	 * @return the dataHoraCreacio
	 */
	public LocalDateTime getDataHoraCreacio() {
		return dataHoraCreacio;
	}
	/**
	 * @param dataHoraCreacio the dataHoraCreacio to set
	 */
	public void setDataHoraCreacio(LocalDateTime dataHoraCreacio) {
		this.dataHoraCreacio = dataHoraCreacio;
	}
	/**
	 * @return the dataHoraModificacio
	 */
	public LocalDateTime getDataHoraModificacio() {
		return dataHoraModificacio;
	}
	/**
	 * @param dataHoraModificacio the dataHoraModificacio to set
	 */
	public void setDataHoraModificacio(LocalDateTime dataHoraModificacio) {
		this.dataHoraModificacio = dataHoraModificacio;
	}
	/**
	 * @return the usuariModificacio
	 */
	public String getUsuariModificacio() {
		return usuariModificacio;
	}
	/**
	 * @param usuariModificacio the usuariModificacio to set
	 */
	public void setUsuariModificacio(String usuariModificacio) {
		this.usuariModificacio = usuariModificacio;
	}
	/**
	 * @return the nomIdCASS
	 */
	public String getNomIdCASS() {
		return nomIdCASS;
	}
	/**
	 * @param nomIdCASS the nomIdCASS to set
	 */
	public void setNomIdCASS(String nomIdCASS) {
		this.nomIdCASS = nomIdCASS;
	}
	/**
	 * @return the nomIdCASS2
	 */
	public String getNomIdCASS2() {
		return nomIdCASS2;
	}
	/**
	 * @param nomIdCASS2 the nomIdCASS2 to set
	 */
	public void setNomIdCASS2(String nomIdCASS2) {
		this.nomIdCASS2 = nomIdCASS2;
	}
	/**
	 * @return the dataNaixementIdCASS
	 */
	public LocalDate getDataNaixementIdCASS() {
		return dataNaixementIdCASS;
	}
	/**
	 * @param dataNaixementIdCASS the dataNaixementIdCASS to set
	 */
	public void setDataNaixementIdCASS(LocalDate dataNaixementIdCASS) {
		this.dataNaixementIdCASS = dataNaixementIdCASS;
	}
	/**
	 * @return the dataNaixementIdCASS2
	 */
	public LocalDate getDataNaixementIdCASS2() {
		return dataNaixementIdCASS2;
	}
	/**
	 * @param dataNaixementIdCASS2 the dataNaixementIdCASS2 to set
	 */
	public void setDataNaixementIdCASS2(LocalDate dataNaixementIdCASS2) {
		this.dataNaixementIdCASS2 = dataNaixementIdCASS2;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TramitDTO [numeroTramit=" + numeroTramit + ", numeroTiquet=" + numeroTiquet + ", codiTramit=" + codiTramit + ", ultimEstat=" + ultimEstat + ", numeroIdCASS="
				+ numeroIdCASS + ", numeroIdCASS2=" + numeroIdCASS2 + ", documentRelacionat=" + documentRelacionat + ", dataPagament=" + dataPagament + ", quantitat=" + quantitat
				+ ", importTramit=" + importTramit + ", facturaTramit=" + facturaTramit + ", usuariCreacio=" + usuariCreacio + ", dataHoraCreacio=" + dataHoraCreacio
				+ ", dataHoraModificacio=" + dataHoraModificacio + ", usuariModificacio=" + usuariModificacio + ", nomIdCASS=" + nomIdCASS + ", nomIdCASS2=" + nomIdCASS2
				+ ", dataNaixementIdCASS=" + dataNaixementIdCASS + ", dataNaixementIdCASS2=" + dataNaixementIdCASS2 + "]";
	}
	
}
