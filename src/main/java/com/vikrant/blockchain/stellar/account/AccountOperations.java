package com.vikrant.blockchain.stellar.account;

import com.vikrant.blockchain.stellar.common.Constants;
import com.vikrant.blockchain.stellar.util.NetworkUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stellar.sdk.KeyPair;

public class AccountOperations {

  private final static Logger LOGGER = LoggerFactory.getLogger(AccountOperations.class);

  public KeyPair createNewAccount() throws IOException {
    String friendbotUrl = NetworkUtil.resourceBundle.getString(Constants.STELLAR_FRIENDBOT_URL);
    KeyPair pair = KeyPair.random();

    friendbotUrl = String.format(friendbotUrl, pair.getAccountId());
    InputStream response = new URL(friendbotUrl).openStream();
    String body = new Scanner(response, StandardCharsets.UTF_8).useDelimiter("\\A").next();
    LOGGER.info("New account created");

    return pair;
  }

}
