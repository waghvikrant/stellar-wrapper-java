package com.vikrant.blockchain.stellar.util;

import com.vikrant.blockchain.stellar.common.Constants;
import java.util.ResourceBundle;

public class NetworkUtil {

  public static ResourceBundle resourceBundle;
  static {
    resourceBundle = ResourceBundle.getBundle(Constants.FILENAME_STELLAR_POPERTIES);
  }



}
