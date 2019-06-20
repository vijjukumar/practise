package com.vijju.functionalI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by e088740 on 6/5/2019.
 */
public class ProcessTN70 {

    private long lineNumber = 0;

    private static final Integer TRANSACTION_MSG_TYPE_IND_OFFSET=13;
    private static final Integer TRANSACTION_MSG_TYPE_IND_LEN=4;

    private static final Integer TRANSACTION_PAN_OFFSET=17;
    private static final Integer TRANSACTION_PAN_LEN=19;

    private static final Integer TRANSACTION_PROCESSING_CD_OFFSET=36;
    private static final Integer TRANSACTION_PROCESSING_CD_LEN=6;

    private static final Integer TRANSACTION_ORIGINAL_AMOUNT_OFFSET=42;//Used to match transaction in DB
    private static final Integer TRANSACTION_ORIGINAL_AMOUNT_LEN=12;

    private static final Integer TRANSACTION_AMOUNT_OFFSET=54;//This is Settlement Amount
    private static final Integer TRANSACTION_AMOUNT_LEN=12;

    private static final Integer TRANSACTION_PROCESSING_DT_TM_OFFSET=74;
    private static final Integer TRANSACTION_PROCESSING_DT_TM_LEN=12;

    private static final Integer TRANSACTION_FUNC_CD_OFFSET=98;
    private static final Integer TRANSACTION_FUNC_CD_LEN=3;

    private static final Integer TRANSACTION_MSG_REASON_CD_OFFSET=101;
    private static final Integer TRANSACTION_MSG_REASON_CD_LEN=4;

    private static final Integer TRANSACTION_APPROVAL_CD_OFFSET=144;
    private static final Integer TRANSACTION_APPROVAL_CD_LEN=6;

    private static final Integer TRANSACTION_ACQ_REF_DATA_OFFSET=121;
    private static final Integer TRANSACTION_ACQ_REF_DATA_LEN=23;

    private static final Integer TRANSACTION_CARD_ACCEPTOR_ID_OFFSET=161;
    private static final Integer TRANSACTION_CARD_ACCEPTOR_ID_LEN=15;

    private static final Integer TRANSACTION_CARD_ACCEPTOR_NAME_AND_LOC_OFFSET=176;
    private static final Integer TRANSACTION_CARD_ACCEPTOR_NAME_AND_LOC_LEN=83;

    private static final Integer TRANSACTION_MSG_REV_IND_OFFSET=284;
    private static final Integer TRANSACTION_MSG_REV_IND_LEN=1;

    private static final Integer TRANSACTION_FEE_PROCESSING_CD_OFFSET=315;
    private static final Integer TRANSACTION_FEE_PROCESSING_CD_LEN=2;

    private static final Integer TRANSACTION_CURRENCY_CD_OFFSET=319;
    private static final Integer TRANSACTION_CURRENCY_CD_LEN=3;

    private static final Integer TRANSACTION_ICHG_FEE_OFFSET=337;
    private static final Integer TRANSACTION_ICHG_FEE_LEN=12;

    private static final Integer TRANSACTION_SETTLEMENT_SERVICE_ID_OFFSET=474;
    private static final Integer TRANSACTION_SETTLEMENT_SERVICE_ID_LEN=10;

    private static final Integer TRANSACTION_SETTLEMENT_DATE_OFFSET=493;
    private static final Integer TRANSACTION_SETTLEMENT_DATE_LEN=6;

    private static final Integer TRANSACTION_SETTLEMENT_CURRENCY_OFFSET=504;
    private static final Integer TRANSACTION_SETTLEMENT_CURRENCY_LEN=3;

    public static final Integer HEADER_ICA_OFFSET=18;
    public static final Integer HEADER_ICA_LEN=11;

public void readFile()throws Exception{
     BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\e088740\\Documents\\practise\\src\\com\\vijju\\functionalI\\TN70.txt"), "UTF8"));
     readNextRecord(reader);

}

    private void readNextRecord(BufferedReader reader) throws IOException {
        String transactionLine = reader.readLine();
        lineNumber++;

        if (transactionLine == null) {
            if (lineNumber == 1) {
               System.out.println("Empty file encountered. Skipping the reader.");
            }
            // there are no more records so close the file and return null to stop spring from reading additional records

        }
        while(transactionLine!=null) {
            System.out.println("messageType " + parseField(transactionLine, TRANSACTION_MSG_TYPE_IND_OFFSET, TRANSACTION_MSG_TYPE_IND_LEN));


            System.out.println("PAN : acs accofunt number acct_num " + parseField(transactionLine, TRANSACTION_PAN_OFFSET, TRANSACTION_PAN_LEN).replaceAll("\\s+", ""));
            System.out.println("APPROVAL PROCESSING CD AUTH_ID_RESP_CD " + parseField(transactionLine, TRANSACTION_PROCESSING_CD_OFFSET, TRANSACTION_PROCESSING_CD_LEN));
            System.out.println("TRANSACTION  AMOUNT getTransactionAmount" + parseField(transactionLine, TRANSACTION_AMOUNT_OFFSET, TRANSACTION_AMOUNT_LEN));// This is Settlement Amount
            System.out.println("DATE TIME PROCESSING transcreatedate" + parseField(transactionLine, TRANSACTION_PROCESSING_DT_TM_OFFSET, TRANSACTION_PROCESSING_DT_TM_LEN));
            System.out.println("FUNCTION CODE " + parseField(transactionLine, TRANSACTION_FUNC_CD_OFFSET, TRANSACTION_FUNC_CD_LEN));
            System.out.println("MESSAGE REASON CODE " + parseField(transactionLine, TRANSACTION_MSG_REASON_CD_OFFSET, TRANSACTION_MSG_REASON_CD_LEN));
            System.out.println("ACQ REF TRANSACTION " + parseField(transactionLine, TRANSACTION_ACQ_REF_DATA_OFFSET, TRANSACTION_ACQ_REF_DATA_LEN));
            System.out.println("TRNASACTION APPROVAL CD " + parseField(transactionLine, TRANSACTION_APPROVAL_CD_OFFSET, TRANSACTION_APPROVAL_CD_LEN));
            System.out.println("CARD ACCEPTOR OFFSET ID " + parseField(transactionLine, TRANSACTION_CARD_ACCEPTOR_ID_OFFSET,
                    TRANSACTION_CARD_ACCEPTOR_ID_LEN));
            System.out.println("CARD ACCEPTOR NAME AND LOCATION " + parseField(transactionLine, TRANSACTION_CARD_ACCEPTOR_NAME_AND_LOC_OFFSET, TRANSACTION_CARD_ACCEPTOR_NAME_AND_LOC_LEN));
            System.out.println("MESSGE REV IND " + parseField(transactionLine, TRANSACTION_MSG_REV_IND_OFFSET, TRANSACTION_MSG_REV_IND_LEN));
            System.out.println("FEE PROCESSING CODE " + parseField(transactionLine, TRANSACTION_FEE_PROCESSING_CD_OFFSET, TRANSACTION_FEE_PROCESSING_CD_LEN));
            System.out.println("TRANSACTION CURRENCTY CD OFFSET " + parseField(transactionLine, TRANSACTION_CURRENCY_CD_OFFSET, TRANSACTION_CURRENCY_CD_LEN));
            System.out.println("TRANSACTION ICHG FEE " + parseField(transactionLine, TRANSACTION_ICHG_FEE_OFFSET, TRANSACTION_ICHG_FEE_LEN));
            System.out.println("TRANSACTION SETTLEMNT SERVICE ID OFFSET " + parseField(transactionLine, TRANSACTION_SETTLEMENT_SERVICE_ID_OFFSET, TRANSACTION_SETTLEMENT_SERVICE_ID_LEN));
            System.out.println("SETTLEMENT DATE OFFSET " + parseField(transactionLine, TRANSACTION_SETTLEMENT_DATE_OFFSET, TRANSACTION_SETTLEMENT_DATE_LEN));
            System.out.println("CURRENCY CODE " + parseField(transactionLine, TRANSACTION_SETTLEMENT_CURRENCY_OFFSET, TRANSACTION_SETTLEMENT_CURRENCY_LEN));
            System.out.println("ORIGINAL AMOUNT TRASANCTION " + parseField(transactionLine, TRANSACTION_ORIGINAL_AMOUNT_OFFSET, TRANSACTION_ORIGINAL_AMOUNT_LEN));
            transactionLine = reader.readLine();
        }
        reader.close();
        }

    public static String parseField(String record, int startingPosition, int length) {
        return record.substring(startingPosition-1, startingPosition+length-1);
    }




}


