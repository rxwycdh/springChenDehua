package api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author fuce
 * @ClassName: AjaxResult
 * @Description: TODO(ajax操作消息提醒)
 * @date 2018年8月18日
 */
@ApiModel(value = "AjaxResult对象", description = "ajax返回对象")
public class AjaxResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码")
    private Integer code = HTTPErrorCode.HTTP_ERROR_CODE_500_INTERNAL_ERROR.getValue();

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回对象")
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult() {
    }

    public AjaxResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static<T> AjaxResult<T> error() {
        return new AjaxResult<T>(HTTPErrorCode.HTTP_ERROR_CODE_400_BAD_REQUEST.getValue(), "操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 内容
     * @return 错误消息
     */
    public static<T> AjaxResult<T> error(String msg) {
        return new AjaxResult<T>(HTTPErrorCode.HTTP_ERROR_CODE_500_INTERNAL_ERROR.getValue(), msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public static<T> AjaxResult<T> error(int code, String msg) {
        return new AjaxResult<T>(code, msg);
    }

    /**
     * 返回成功消息
     *
     * @param msg 内容
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success(String msg) {
        return new AjaxResult<T>(HTTPErrorCode.HTTP_ERROR_CODE_200_OK.getValue(), msg);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功和对象
     *
     * @return 成功消息
     */
    public static<T> AjaxResult<T> successData(T data) {

        return new AjaxResult<T>(HTTPErrorCode.HTTP_ERROR_CODE_200_OK.getValue(), "操作成功", data);
    }

    /**
     * 返回成功和list对象
     *
     * @return 成功消息
     */
    public static<T> AjaxResult<TableSplitResult<T>> successDataList(List<T> list) {

        TableSplitResult<T> result = new TableSplitResult<T>(list);
        return AjaxResult.successData(result);
    }

}
