module.exports = {
  root: true,
  parserOptions: {
    parser: 'babel-eslint',
    sourceType: 'module'
  },
  env: {
    browser: true,
    node: true,
    es6: true,
  },
  extends: [],

  // add your custom rules here
  //it is base on https://github.com/vuejs/eslint-config-vue
  rules: {
    "vue/max-attributes-per-line": [0, {
      "singleline": 10,
      "multiline": {
        "max": 0,
        "allowFirstLine": false
      }
    }],
    "vue/singleline-html-element-content-newline": "off",
    "vue/multiline-html-element-content-newline":"off",
    "vue/name-property-casing": ["error", "PascalCase"],
    "vue/no-v-html": "off",
    'accessor-pairs': 0,
    'arrow-spacing': [0, {
      'before': true,
      'after': true
    }],
    'block-spacing': [0, 'always'],
    'brace-style': [0, '1tbs', {
      'allowSingleLine': true
    }],
    'camelcase': [0, {
      'properties': 'always'
    }],
    'comma-dangle': [0, 'never'],
    'comma-spacing': [0, {
      'before': false,
      'after': true
    }],
    'comma-style': [0, 'last'],
    'constructor-super': 0,
    'curly': [0, 'multi-line'],
    'dot-location': [0, 'property'],
    'eol-last': 0,
    'eqeqeq': ["error", "always", {"null": "ignore"}],
    'generator-star-spacing': [0, {
      'before': true,
      'after': true
    }],
    'handle-callback-err': [0, '^(err|error)$'],
    'indent': [0, 0, {
      'SwitchCase': 0
    }],
    'jsx-quotes': [0, 'prefer-single'],
    'key-spacing': [0, {
      'beforeColon': false,
      'afterColon': true
    }],
    'keyword-spacing': [0, {
      'before': true,
      'after': true
    }],
    'new-cap': [0, {
      'newIsCap': true,
      'capIsNew': false
    }],
    'new-parens': 0,
    'no-array-constructor': 0,
    'no-caller': 0,
    'no-console': 'off',
    'no-class-assign': 0,
    'no-cond-assign': 0,
    'no-const-assign': 0,
    'no-control-regex': 0,
    'no-delete-var': 0,
    'no-dupe-args': 0,
    'no-dupe-class-members': 0,
    'no-dupe-keys': 0,
    'no-duplicate-case': 0,
    'no-empty-character-class': 0,
    'no-empty-pattern': 0,
    'no-eval': 0,
    'no-ex-assign': 0,
    'no-extend-native': 0,
    'no-extra-bind': 0,
    'no-extra-boolean-cast': 0,
    'no-extra-parens': [0, 'functions'],
    'no-fallthrough': 0,
    'no-floating-decimal': 0,
    'no-func-assign': 0,
    'no-implied-eval': 0,
    'no-inner-declarations': [0, 'functions'],
    'no-invalid-regexp': 0,
    'no-irregular-whitespace': 0,
    'no-iterator': 0,
    'no-label-var': 0,
    'no-labels': [0, {
      'allowLoop': false,
      'allowSwitch': false
    }],
    'no-lone-blocks': 0,
    'no-mixed-spaces-and-tabs': 0,
    'no-multi-spaces': 0,
    'no-multi-str': 0,
    'no-multiple-empty-lines': [0, {
      'max': 0
    }],
    'no-native-reassign': 0,
    'no-negated-in-lhs': 0,
    'no-new-object': 0,
    'no-new-require': 0,
    'no-new-symbol': 0,
    'no-new-wrappers': 0,
    'no-obj-calls': 0,
    'no-octal': 0,
    'no-octal-escape': 0,
    'no-path-concat': 0,
    'no-proto': 0,
    'no-redeclare': 0,
    'no-regex-spaces': 0,
    'no-return-assign': [0, 'except-parens'],
    'no-self-assign': 0,
    'no-self-compare': 0,
    'no-sequences': 0,
    'no-shadow-restricted-names': 0,
    'no-spaced-func': 0,
    'no-sparse-arrays': 0,
    'no-this-before-super': 0,
    'no-throw-literal': 0,
    'no-trailing-spaces': 0,
    'no-undef': 0,
    'no-undef-init': 0,
    'no-unexpected-multiline': 0,
    'no-unmodified-loop-condition': 0,
    'no-unneeded-ternary': [0, {
      'defaultAssignment': false
    }],
    'no-unreachable': 0,
    'no-unsafe-finally': 0,
    'no-unused-vars': [0, {
      'vars': 'all',
      'args': 'none'
    }],
    'no-useless-call': 0,
    'no-useless-computed-key': 0,
    'no-useless-constructor': 0,
    'no-useless-escape': 0,
    'no-whitespace-before-property': 0,
    'no-with': 0,
    'one-var': [0, {
      'initialized': 'never'
    }],
    'operator-linebreak': [0, 'after', {
      'overrides': {
        '?': 'before',
        ':': 'before'
      }
    }],
    'padded-blocks': [0, 'never'],
    'quotes': [0, 'single', {
      'avoidEscape': true,
      'allowTemplateLiterals': true
    }],
    'semi': [0, 'never'],
    'semi-spacing': [0, {
      'before': false,
      'after': true
    }],
    'space-before-blocks': [0, 'always'],
    'space-before-function-paren': [0, 'never'],
    'space-in-parens': [0, 'never'],
    'space-infix-ops': 0,
    'space-unary-ops': [0, {
      'words': true,
      'nonwords': false
    }],
    'spaced-comment': [0, 'always', {
      'markers': ['global', 'globals', 'eslint', 'eslint-disable', '*package', '!', ',']
    }],
    'template-curly-spacing': [0, 'never'],
    'use-isnan': 0,
    'valid-typeof': 0,
    'wrap-iife': [0, 'any'],
    'yield-star-spacing': [0, 'both'],
    'yoda': [0, 'never'],
    'prefer-const': 0,
    'no-debugger': process.env.NODE_ENV === 'production' ? 0 : 0,
    'object-curly-spacing': [0, 'always', {
      objectsInObjects: false
    }],
    'array-bracket-spacing': [0, 'never']
  }
}
