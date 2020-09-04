package org.analysis.core.security;

import lombok.Data;
import support.Kv;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:20
 */
@Data
public class TokenParameter {

    private Kv args = Kv.init();
}
