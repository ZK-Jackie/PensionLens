export const income_and_expense01 = [//第一套广东省城镇养老保险未来收入和支出，柱形图
    {
        dataId: 1,
        displayMode: "bar",
        startTime: "2022",
        endTime: "2026",
        predictStartTime: "2024",
        predictEndTime: "2026",
        chartOption: {
            dataId: 1,
            dataName: "收入",
            displayableMode: ["bar", "linear"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿元",
            numPrecision: '1',
            maxValue: 8000,
            minValue: 3000,
            dataColor: ['#2f89cf'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026],
                [6866,6975,7164,7384,7607]
            ],
        }
    },
    {
        dataId: 2,
        displayMode: "bar",
        startTime: "2022",
        endTime: "2026",
        predictStartTime: "2024",
        predictEndTime: "2026",
        chartOption: {
            dataId: 2,
            dataName: "支出",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿元",
            numPrecision: '1',
            maxValue: 8000,
            minValue: 3000,
            dataColor: ['#27d08a'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026],
                [3942,4147,4338,4556,4795]
            ]
        }
    }
]

export const income_and_expense02 = [//第二套广东省城镇养老保险未来收入和支出，柱形图
    {
        detailId: 2,
        dataId: 1,
        displayMode: "bar",
        startTime: "2022",
        endTime: "2026",
        predictStartTime: "2024",
        predictEndTime: "2026",
        chartOption: {
            dataId: 1,
            dataName: "收入",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿元",
            numPrecision: '1',
            maxValue: 8000,
            minValue: 3000,
            dataColor: ['#2f89cf'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026],
                [6786,6975,7214,7424,7637]
            ],
        }
    },
    {
        dataId: 2,
        displayMode: "bar",
        startTime: "2020",
        endTime: "2026",
        predictStartTime: "2024",
        predictEndTime: "2026",
        chartOption: {
            dataId: 2,
            dataName: "支出",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿元",
            numPrecision: '1',
            maxValue: 8000,
            minValue: 3000,
            dataColor: ['#27d08a'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026],
                [3942,4147,4398,4611,4821]
            ]
        }
    }
]


export const H_population01 = [
    {
        detailId: 3,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57872605,58085464,58260040,58438437,58578040,5868012,5848785]
            ],
        }
    },
    {
        detailId: 3,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [53033651,53252598,533444014,53642842,53813850,53958366,54078360]
            ],
        }
    }
]
export const M_population01 = [
    {
        detailId: 4,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57639312,57781721,57889605,57967987,58013017,58025958,58009197]
            ],
        }
    },
    {
        detailId: 4,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [52843979,53005102,53141509,53257409,53349628,53419188,534676638]
            ],
        }
    }
]
export const L_population01 = [
    {
        detailId: 5,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57372691,57434589,57466250,57437325,57380883,57297759,57189759]
            ],
        }
    },
    {
        detailId: 5,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [52627211,52722248,2795789,52822717,52830400,52819536,5291220]
            ],
        }
    }
]


export const H_population02 = [
    {
        detailId: 6,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57882505,58095864,58271040,58448537,58585040,5869112,5849285]
            ],
        }
    },
    {
        detailId: 6,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [53040651,53302598,533944014,53682842,53833850,53960366,54098360]
            ],
        }
    }
]
export const M_population02 = [
    {
        detailId: 7,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57709312,57791721,5789605,57977987,58033017,58095958,58010197]
            ],
        }
    },
    {
        detailId: 7,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [52857979,53055102,53141509,53357409,53399628,53479188,535676638]
            ],
        }
    }
]
export const L_population02 = [
    {
        detailId: 8,
        dataId: 1,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 1,
            dataName: "男",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 50000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [57382691,57494589,57576250,57637325,57480883,57397759,57129759]
            ],
        }
    },
    {
        detailId: 8,
        dataId: 2,
        displayMode: "ring",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: null,
        predictEndTime: null,
        chartOption: {
            dataId: 2,
            dataName: "女",
            displayableMode: ["bar", "line", "ring"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "人",
            numPrecision: '1',
            maxValue: 65000000,
            minValue: 55000000,
            dataColor: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            isPredict: false,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [52727211,52792248,52805789,52812717,52830400,52820536,5290220]
            ],
        }
    }
]

export const participants01 = [//第一套广东省城镇职工参保人数，折线图
    {
        detailId: 9,
        dataId: 1,
        displayMode: "linear",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: "2024",
        predictEndTime: "2028",
        chartOption: {
            dataId: 1,
            dataName: "参保人数",
            displayableMode: ["bar", "linear"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿人",
            numPrecision: '1.00',
            maxValue: 1.4,
            minValue: 1.0,
            dataColor: ['#2f89cf'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [1.13,1.15,1.20,1.21,1.25,1.26,1.28]
            ],
        }
    },
]

export const participants02 = [
    {
        detailId: 10,
        dataId: 1,
        displayMode: "linear",
        startTime: "2022",
        endTime: "2028",
        predictStartTime: "2024",
        predictEndTime: "2028",
        chartOption: {
            dataId: 1,
            dataName: "participants",
            displayableMode: ["bar", "line"],
            keyLabel: "x",
            keyUnit: "年",
            valueLabel: "y",
            valueUnit: "亿人",
            numPrecision: '0.01',
            maxValue: 2.5,
            minValue: 1.0,
            dataColor: ['#2f89cf'],
            isPredict: true,
            isInfo: false,
            data: [
                [2022, 2023, 2024, 2025, 2026, 2027, 2028],
                [1.13,1.15,1.21,1.23,1.26,1.27,1.29]
            ],
        }
    },
]

export const gdData=[income_and_expense01,income_and_expense02,H_population01,H_population02,L_population01,L_population02,M_population01,M_population02,participants01,participants02]