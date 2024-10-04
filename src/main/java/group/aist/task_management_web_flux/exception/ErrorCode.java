package group.aist.task_management_web_flux.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SERVER_ERROR,
    DATA_NOT_FOUND

}
