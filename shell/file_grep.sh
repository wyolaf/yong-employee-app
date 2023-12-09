#! /bin/bash
FILE=$1
WORD=$2
EXPORTFILE=$3
if [ $# != 3 ]; then
        echo "参数不正确，参数为：源文件路径 搜索关键词 输出文件路径"
elif [ "${WORD}" == "" ]; then
        echo "搜索关键字未指定"
elif [ "${EXPORTFILE}" == "" ]; then
        echo "目标文件未指定"
else
        touch ${EXPORTFILE}
        echo "--------------------------------------------------" >> ${EXPORTFILE}
        echo "------导出时间：$(date '+%Y-%m-%d %H:%M:%S')------" >> ${EXPORTFILE}
        echo "--------------------------------------------------" >> ${EXPORTFILE}
        cat -n ${FILE} | grep ${WORD} >> ${EXPORTFILE}
        cat ${EXPORTFILE}
fi
