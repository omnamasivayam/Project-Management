package practise.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "KnowledgeTransfers")
public class KnowledgeTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long knowledgeTransferId;

	@ManyToOne
	@JoinColumn(name="empId",insertable=false, updatable=false)
	private Employee knowledgeTransferFrom;
	
	@ManyToOne
	@JoinColumn(name="empId",insertable=false, updatable=false)
	private Employee knowledgeTransferTo;
	
	@Column
	@Type(type="date")
	private Date knowledgeTransferStartDate;
	
	@Column
	@Type(type="date")
	private Date knowledgeTransferEndDate;
	
	@Column
	private String knowledgeTransferTopic;
	
	public long getKnowledgeTransferId() {
		return knowledgeTransferId;
	}

	public void setKnowledgeTransferId(long knowledgeTransferId) {
		this.knowledgeTransferId = knowledgeTransferId;
	}

	public Employee getKnowledgeTransferFrom() {
		return knowledgeTransferFrom;
	}

	public void setKnowledgeTransferFrom(Employee knowledgeTransferFrom) {
		this.knowledgeTransferFrom = knowledgeTransferFrom;
	}

	public Employee getKnowledgeTransferTo() {
		return knowledgeTransferTo;
	}

	public void setKnowledgeTransferTo(Employee knowledgeTransferTo) {
		this.knowledgeTransferTo = knowledgeTransferTo;
	}

	public Date getKnowledgeTransferStartDate() {
		return knowledgeTransferStartDate;
	}

	public void setKnowledgeTransferStartDate(Date knowledgeTransferStartDate) {
		this.knowledgeTransferStartDate = knowledgeTransferStartDate;
	}

	public Date getKnowledgeTransferEndDate() {
		return knowledgeTransferEndDate;
	}

	public void setKnowledgeTransferEndDate(Date knowledgeTransferEndDate) {
		this.knowledgeTransferEndDate = knowledgeTransferEndDate;
	}

	public String getKnowledgeTransferTopic() {
		return knowledgeTransferTopic;
	}

	public void setKnowledgeTransferTopic(String knowledgeTransferTopic) {
		this.knowledgeTransferTopic = knowledgeTransferTopic;
	}

	public KnowledgeTransfer() { }

	public KnowledgeTransfer(long id) { 
		
    this.knowledgeTransferId = id;
    
	}
  
	public KnowledgeTransfer(Employee from, Employee to , Date startDate, Date endDate, String topic) {  
    this.knowledgeTransferFrom = from;
    this.knowledgeTransferTo = to;
    this.knowledgeTransferEndDate = startDate;
    this.knowledgeTransferEndDate = endDate;
    this.knowledgeTransferTopic = topic;
	}
	
}
