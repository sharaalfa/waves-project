package io.equitycharger.sharhack.databasetemplatejson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Txs4 {

  private long height;
  private long txType;
  @Id
  private String id;
  private Timestamp timeStamp;
  private String signature;
  private String proofs;
  private long txVersion;

  private String sender;
  private String senderPublicKey;
  private long fee;
  private String assetId;
  private long amount;
  private String recipient;
  private String feeAsset;
  private String attachment;





  public long getHeight() {
    return height;
  }

  public void setHeight(long height) {
    this.height = height;
  }


  public long getTxType() {
    return txType;
  }

  public void setTxType(long txType) {
    this.txType = txType;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Timestamp getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Timestamp timeStamp) {
    this.timeStamp = timeStamp;
  }


  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }


  public String getProofs() {
    return proofs;
  }

  public void setProofs(String proofs) {
    this.proofs = proofs;
  }


  public long getTxVersion() {
    return txVersion;
  }

  public void setTxVersion(long txVersion) {
    this.txVersion = txVersion;
  }


  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }


  public String getSenderPublicKey() {
    return senderPublicKey;
  }

  public void setSenderPublicKey(String senderPublicKey) {
    this.senderPublicKey = senderPublicKey;
  }


  public long getFee() {
    return fee;
  }

  public void setFee(long fee) {
    this.fee = fee;
  }


  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }


  public String getFeeAsset() {
    return feeAsset;
  }

  public void setFeeAsset(String feeAsset) {
    this.feeAsset = feeAsset;
  }


  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

}
