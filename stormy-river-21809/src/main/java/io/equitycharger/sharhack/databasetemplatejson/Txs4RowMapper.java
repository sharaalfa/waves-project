package io.equitycharger.sharhack.databasetemplatejson;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Txs4RowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Txs4 txs4 = new Txs4();
        txs4.setAmount(rs.getLong("amount"));
        txs4.setAssetId(rs.getString("asset_id"));
        txs4.setAttachment(rs.getString("attachment"));
        txs4.setFeeAsset(rs.getString("fee_asset"));
        txs4.setHeight(rs.getLong("height"));
        txs4.setId(rs.getString("id"));
        txs4.setRecipient(rs.getString("recipient"));
        txs4.setProofs(rs.getString("proofs"));
        txs4.setSender(rs.getString("sender"));
        txs4.setSignature(rs.getString("signature"));
        txs4.setSenderPublicKey(rs.getString("sender_public_key"));
        txs4.setTimeStamp(rs.getTimestamp("time_stamp"));
        txs4.setTxType(rs.getShort("tx_type"));
        txs4.setTxVersion(rs.getLong("tx_version"));
        txs4.setFee(rs.getLong("fee"));
        return txs4;

    }
}
