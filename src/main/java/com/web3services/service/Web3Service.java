package com.web3services.service;

import org.web3j.abi.datatypes.Event;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public interface Web3Service {

    EthBlock.Block getBlockByNumber(BigInteger blockNumber) throws IOException;

    EthBlock.Block getLatestBlock() throws IOException;

    List<EthBlock.TransactionResult> getBlockTransactions(BigInteger blockNumber) throws IOException;

}
