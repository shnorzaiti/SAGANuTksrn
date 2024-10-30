!function(e) {
    function t(e) {
        var t = document.createElement("input"), i = "on" + e, a = i in t;
        return a || (t.setAttribute(i, "return;"), a = "function" == typeof t[i]), t = null, a
    }
    function i(e) {
        var t = "text" == e || "tel" == e;
        if (!t) {
            var i = document.createElement("input");
            i.setAttribute("type", e), t = "text" === i.type, i = null
        }
        return t
    }
    function a(t, i, n) {
        var o = n.aliases[t];
        return o ? (o.alias && a(o.alias, void 0, n), e.extend(!0, n, o), e.extend(!0, n, i), !0) : !1
    }
    function n(t) {
        function i(i) {
            function a(e, t, i, a) {
                this.matches = [], this.isGroup = e || !1, this.isOptional = t || !1, this.isQuantifier = i || !1, this.isAlternator = a || !1, this.quantifier = {min: 1, max: 1}
            }
            function n(i, a, n) {
                var o = t.definitions[a], r = 0 == i.matches.length;
                if (n = void 0 != n ? n : i.matches.length, o && !p) {
                    o.placeholder = e.isFunction(o.placeholder) ? o.placeholder.call(this, t) : o.placeholder;
                    for (var s = o.prevalidator, l = s ? s.length : 0, u = 1; u < o.cardinality; u++) {
                        var c = l >= u ? s[u - 1] : [], d = c.validator, v = c.cardinality;
                        i.matches.splice(n++, 0, {fn: d ? "string" == typeof d ? new RegExp(d) : new function() {
                                this.test = d
                            } : new RegExp("."), cardinality: v ? v : 1, optionality: i.isOptional, newBlockMarker: r, casing: o.casing, def: o.definitionSymbol || a, placeholder: o.placeholder, mask: a})
                    }
                    i.matches.splice(n++, 0, {fn: o.validator ? "string" == typeof o.validator ? new RegExp(o.validator) : new function() {
                            this.test = o.validator
                        } : new RegExp("."), cardinality: o.cardinality, optionality: i.isOptional, newBlockMarker: r, casing: o.casing, def: o.definitionSymbol || a, placeholder: o.placeholder, mask: a})
                } else
                    i.matches.splice(n++, 0, {fn: null, cardinality: 0, optionality: i.isOptional, newBlockMarker: r, casing: null, def: a, placeholder: void 0, mask: a}), p = !1
            }
            for (var o, r, s, l, u, c, d = /(?:[?*+]|\{[0-9\+\*]+(?:,[0-9\+\*]*)?\})\??|[^.?*+^${[]()|\\]+|./g, p = !1, v = new a, f = [], m = []; o = d.exec(i); )
                switch (r = o[0], r.charAt(0)) {
                    case t.optionalmarker.end:
                    case t.groupmarker.end:
                        if (s = f.pop(), f.length > 0) {
                            if (l = f[f.length - 1], l.matches.push(s), l.isAlternator) {
                                u = f.pop();
                                for (var h = 0; h < u.matches.length; h++)
                                    u.matches[h].isGroup = !1;
                                f.length > 0 ? (l = f[f.length - 1], l.matches.push(u)) : v.matches.push(u)
                            }
                        } else
                            v.matches.push(s);
                        break;
                    case t.optionalmarker.start:
                        f.push(new a(!1, !0));
                        break;
                    case t.groupmarker.start:
                        f.push(new a(!0));
                        break;
                    case t.quantifiermarker.start:
                        var k = new a(!1, !1, !0);
                        r = r.replace(/[{}]/g, "");
                        var g = r.split(","), b = isNaN(g[0]) ? g[0] : parseInt(g[0]), y = 1 == g.length ? b : isNaN(g[1]) ? g[1] : parseInt(g[1]);
                        if (("*" == y || "+" == y) && (b = "*" == y ? 0 : 1), k.quantifier = {min: b, max: y}, f.length > 0) {
                            var _ = f[f.length - 1].matches;
                            if (o = _.pop(), !o.isGroup) {
                                var P = new a(!0);
                                P.matches.push(o), o = P
                            }
                            _.push(o), _.push(k)
                        } else {
                            if (o = v.matches.pop(), !o.isGroup) {
                                var P = new a(!0);
                                P.matches.push(o), o = P
                            }
                            v.matches.push(o), v.matches.push(k)
                        }
                        break;
                    case t.escapeChar:
                        p = !0;
                        break;
                    case t.alternatormarker:
                        f.length > 0 ? (l = f[f.length - 1], c = l.matches.pop()) : c = v.matches.pop(), c.isAlternator ? f.push(c) : (u = new a(!1, !1, !1, !0), u.matches.push(c), f.push(u));
                        break;
                    default:
                        if (f.length > 0) {
                            if (l = f[f.length - 1], l.matches.length > 0 && (c = l.matches[l.matches.length - 1], c.isGroup && (c.isGroup = !1, n(c, t.groupmarker.start, 0), n(c, t.groupmarker.end))), n(l, r), l.isAlternator) {
                                u = f.pop();
                                for (var h = 0; h < u.matches.length; h++)
                                    u.matches[h].isGroup = !1;
                                f.length > 0 ? (l = f[f.length - 1], l.matches.push(u)) : v.matches.push(u)
                            }
                        } else
                            v.matches.length > 0 && (c = v.matches[v.matches.length - 1], c.isGroup && (c.isGroup = !1, n(c, t.groupmarker.start, 0), n(c, t.groupmarker.end))), n(v, r)
                }
            return v.matches.length > 0 && (c = v.matches[v.matches.length - 1], c.isGroup && (c.isGroup = !1, n(c, t.groupmarker.start, 0), n(c, t.groupmarker.end)), m.push(v)), m
        }
        function a(a, n) {
            if (void 0 == a || "" == a)
                return void 0;
            if (1 == a.length && 0 == t.greedy && 0 != t.repeat && (t.placeholder = ""), t.repeat > 0 || "*" == t.repeat || "+" == t.repeat) {
                var o = "*" == t.repeat ? 0 : "+" == t.repeat ? 1 : t.repeat;
                a = t.groupmarker.start + a + t.groupmarker.end + t.quantifiermarker.start + o + "," + t.repeat + t.quantifiermarker.end
            }
            return void 0 == e.inputmask.masksCache[a] && (e.inputmask.masksCache[a] = {mask: a, maskToken: i(a), validPositions: {}, _buffer: void 0, buffer: void 0, tests: {}, metadata: n}), e.extend(!0, {}, e.inputmask.masksCache[a])
        }
        function n(e) {
            if (e = e.toString(), t.numericInput) {
                e = e.split("").reverse();
                for (var i = 0; i < e.length; i++)
                    e[i] == t.optionalmarker.start ? e[i] = t.optionalmarker.end : e[i] == t.optionalmarker.end ? e[i] = t.optionalmarker.start : e[i] == t.groupmarker.start ? e[i] = t.groupmarker.end : e[i] == t.groupmarker.end && (e[i] = t.groupmarker.start);
                e = e.join("")
            }
            return e
        }
        var o = void 0;
        if (e.isFunction(t.mask) && (t.mask = t.mask.call(this, t)), e.isArray(t.mask)) {
            if (t.mask.length > 1) {
                t.keepStatic = void 0 == t.keepStatic ? !0 : t.keepStatic;
                var r = "(";
                return e.each(t.mask, function(t, i) {
                    r.length > 1 && (r += ")|("), r += n(void 0 == i.mask || e.isFunction(i.mask) ? i : i.mask)
                }), r += ")", a(r, t.mask)
            }
            t.mask = t.mask.pop()
        }
        return t.mask && (o = void 0 == t.mask.mask || e.isFunction(t.mask.mask) ? a(n(t.mask), t.mask) : a(n(t.mask.mask), t.mask)), o
    }
    function o(a, n, o) {
        function r(e, t, i) {
            t = t || 0;
            var a, n, o, r = [], s = 0;
            do {
                if (e === !0 && c().validPositions[s]) {
                    var l = c().validPositions[s];
                    n = l.match, a = l.locator.slice(), r.push(i === !0 ? l.input : j(s, n))
                } else
                    o = m(s, a, s - 1), n = o.match, a = o.locator.slice(), r.push(j(s, n));
                s++
            } while ((void 0 == at || at > s - 1) && null != n.fn || null == n.fn && "" != n.def || t >= s);
            return r.pop(), r
        }
        function c() {
            return n
        }
        function d(e) {
            var t = c();
            t.buffer = void 0, t.tests = {}, e !== !0 && (t._buffer = void 0, t.validPositions = {}, t.p = 0)
        }
        function p(e) {
            var t = c(), i = -1, a = t.validPositions;
            void 0 == e && (e = -1);
            var n = i, o = i;
            for (var r in a) {
                var s = parseInt(r);
                (-1 == e || null != a[s].match.fn) && (e >= s && (n = s), s >= e && (o = s))
            }
            return i = -1 != n && e - n > 1 || e > o ? n : o
        }
        function v(t, i, a) {
            if (o.insertMode && void 0 != c().validPositions[t] && void 0 == a) {
                var n, r = e.extend(!0, {}, c().validPositions), s = p();
                for (n = t; s >= n; n++)
                    delete c().validPositions[n];
                c().validPositions[t] = i;
                var l, u = !0;
                for (n = t; s >= n; n++) {
                    var d = r[n];
                    if (void 0 != d) {
                        var v = c().validPositions;
                        l = !o.keepStatic && v[n] && (void 0 != v[n + 1] && g(n + 1, v[n].locator.slice(), n).length > 1 || void 0 != v[n].alternation) ? n + 1 : A(n), u = k(l, d.match.def) ? u && C(l, d.input, !0, !0) !== !1 : null == d.match.fn
                    }
                    if (!u)
                        break
                }
                if (!u)
                    return c().validPositions = e.extend(!0, {}, r), !1
            } else
                c().validPositions[t] = i;
            return!0
        }
        function f(e, t, i, a) {
            var n, r = e;
            c().p = e, void 0 != c().validPositions[e] && c().validPositions[e].input == o.radixPoint && (t++, r++);
            for (n = r; t > n; n++)
                void 0 != c().validPositions[n] && (i === !0 || 0 != o.canClearPosition(c(), n, p(), a, o)) && delete c().validPositions[n];
            for (d(!0), n = r + 1; n <= p(); ) {
                for (; void 0 != c().validPositions[r]; )
                    r++;
                var s = c().validPositions[r];
                r > n && (n = r + 1);
                var l = c().validPositions[n];
                void 0 != l && void 0 == s ? (k(r, l.match.def) && C(r, l.input, !0) !== !1 && (delete c().validPositions[n], n++), r++) : n++
            }
            var u = p();
            u >= e && void 0 != c().validPositions[u] && c().validPositions[u].input == o.radixPoint && delete c().validPositions[u], d(!0)
        }
        function m(e, t, i) {
            for (var a, n = g(e, t, i), r = p(), s = c().validPositions[r] || g(0)[0], l = void 0 != s.alternation ? s.locator[s.alternation].split(",") : [], u = 0; u < n.length && (a = n[u], !(a.match && (o.greedy && a.match.optionalQuantifier !== !0 || (a.match.optionality === !1 || a.match.newBlockMarker === !1) && a.match.optionalQuantifier !== !0) && (void 0 == s.alternation || void 0 != a.locator[s.alternation] && E(a.locator[s.alternation].toString().split(","), l)))); u++)
                ;
            return a
        }
        function h(e) {
            return c().validPositions[e] ? c().validPositions[e].match : g(e)[0].match
        }
        function k(e, t) {
            for (var i = !1, a = g(e), n = 0; n < a.length; n++)
                if (a[n].match && a[n].match.def == t) {
                    i = !0;
                    break
                }
            return i
        }
        function g(t, i, a) {
            function n(i, a, o, s) {
                function d(o, s, v) {
                    if (r > 1e4)
                        return alert("jquery.inputmask: There is probably an error in your mask definition or in the code. Create an issue on github with an example of the mask you are using. " + c().mask), !0;
                    if (r == t && void 0 == o.matches)
                        return l.push({match: o, locator: s.reverse()}), !0;
                    if (void 0 != o.matches) {
                        if (o.isGroup && v !== !0) {
                            if (o = d(i.matches[p + 1], s))
                                return!0
                        } else if (o.isOptional) {
                            var f = o;
                            if (o = n(o, a, s, v)) {
                                var m = l[l.length - 1].match, h = 0 == e.inArray(m, f.matches);
                                h && (u = !0), r = t
                            }
                        } else if (o.isAlternator) {
                            var k, g = o, b = [], y = l.slice(), _ = s.length, P = a.length > 0 ? a.shift() : -1;
                            if (-1 == P || "string" == typeof P) {
                                var E, C = r, x = a.slice();
                                "string" == typeof P && (E = P.split(","));
                                for (var M = 0; M < g.matches.length; M++) {
                                    l = [], o = d(g.matches[M], [M].concat(s), v) || o, k = l.slice(), r = C, l = [];
                                    for (var A = 0; A < x.length; A++)
                                        a[A] = x[A];
                                    for (var w = 0; w < k.length; w++)
                                        for (var S = k[w], O = 0; O < b.length; O++) {
                                            var j = b[O];
                                            if (S.match.mask == j.match.mask && ("string" != typeof P || -1 != e.inArray(S.locator[_].toString(), E))) {
                                                k.splice(w, 1), j.locator[_] = j.locator[_] + "," + S.locator[_], j.alternation = _;
                                                break
                                            }
                                        }
                                    b = b.concat(k)
                                }
                                "string" == typeof P && (b = e.map(b, function(t, i) {
                                    if (isFinite(i)) {
                                        var a, n = t.locator[_].toString().split(",");
                                        t.locator[_] = void 0, t.alternation = void 0;
                                        for (var o = 0; o < n.length; o++)
                                            a = -1 != e.inArray(n[o], E), a && (void 0 != t.locator[_] ? (t.locator[_] += ",", t.alternation = _, t.locator[_] += n[o]) : t.locator[_] = parseInt(n[o]));
                                        if (void 0 != t.locator[_])
                                            return t
                                    }
                                })), l = y.concat(b), u = !0
                            } else
                                o = d(g.matches[P], [P].concat(s), v);
                            if (o)
                                return!0
                        } else if (o.isQuantifier && v !== !0)
                            for (var T = o, G = a.length > 0 && v !== !0 ? a.shift() : 0; G < (isNaN(T.quantifier.max) ? G + 1 : T.quantifier.max) && t >= r; G++) {
                                var D = i.matches[e.inArray(T, i.matches) - 1];
                                if (o = d(D, [G].concat(s), !0)) {
                                    var m = l[l.length - 1].match;
                                    m.optionalQuantifier = G > T.quantifier.min - 1;
                                    var h = 0 == e.inArray(m, D.matches);
                                    if (h) {
                                        if (G > T.quantifier.min - 1) {
                                            u = !0, r = t;
                                            break
                                        }
                                        return!0
                                    }
                                    return!0
                                }
                            }
                        else if (o = n(o, a, s, v))
                            return!0
                    } else
                        r++
                }
                for (var p = a.length > 0 ? a.shift() : 0; p < i.matches.length; p++)
                    if (i.matches[p].isQuantifier !== !0) {
                        var v = d(i.matches[p], [p].concat(o), s);
                        if (v && r == t)
                            return v;
                        if (r > t)
                            break
                    }
            }
            var o = c().maskToken, r = i ? a : 0, s = i || [0], l = [], u = !1;
            if (void 0 == i) {
                for (var d, p = t - 1; void 0 == (d = c().validPositions[p]) && p > - 1; )
                    p--;
                if (void 0 != d && p > -1)
                    r = p, s = d.locator.slice();
                else {
                    for (p = t - 1; void 0 == (d = c().tests[p]) && p > - 1; )
                        p--;
                    void 0 != d && p > -1 && (r = p, s = d[0].locator.slice())
                }
            }
            for (var v = s.shift(); v < o.length; v++) {
                var f = n(o[v], s, [v]);
                if (f && r == t || r > t)
                    break
            }
            return(0 == l.length || u) && l.push({match: {fn: null, cardinality: 0, optionality: !0, casing: null, def: ""}, locator: []}), c().tests[t] = e.extend(!0, [], l), c().tests[t]
        }
        function b() {
            return void 0 == c()._buffer && (c()._buffer = r(!1, 1)), c()._buffer
        }
        function y() {
            return void 0 == c().buffer && (c().buffer = r(!0, p(), !0)), c().buffer
        }
        function _(e, t, i) {
            if (i = i || y().slice(), e === !0)
                d(), e = 0, t = i.length;
            else
                for (var a = e; t > a; a++)
                    delete c().validPositions[a], delete c().tests[a];
            for (var a = e; t > a; a++)
                i[a] != o.skipOptionalPartCharacter && C(a, i[a], !0, !0)
        }
        function P(e, t) {
            switch (t.casing) {
                case"upper":
                    e = e.toUpperCase();
                    break;
                case"lower":
                    e = e.toLowerCase()
            }
            return e
        }
        function E(t, i) {
            for (var a = o.greedy ? i : i.slice(0, 1), n = !1, r = 0; r < t.length; r++)
                if (-1 != e.inArray(t[r], a)) {
                    n = !0;
                    break
                }
            return n
        }
        function C(t, i, a, n) {
            function r(t, i, a, n) {
                var r = !1;
                return e.each(g(t), function(s, l) {
                    for (var u = l.match, m = i ? 1 : 0, h = "", k = (y(), u.cardinality); k > m; k--)
                        h += S(t - (k - 1));
                    if (i && (h += i), r = null != u.fn ? u.fn.test(h, c(), t, a, o) : i != u.def && i != o.skipOptionalPartCharacter || "" == u.def ? !1 : {c: u.def, pos: t}, r !== !1) {
                        var g = void 0 != r.c ? r.c : i;
                        g = g == o.skipOptionalPartCharacter && null === u.fn ? u.def : g;
                        var b = t;
                        if (void 0 != r.remove && f(r.remove, r.remove + 1, !0), r.refreshFromBuffer) {
                            var E = r.refreshFromBuffer;
                            if (a = !0, _(E === !0 ? E : E.start, E.end), void 0 == r.pos && void 0 == r.c)
                                return r.pos = p(), !1;
                            if (b = void 0 != r.pos ? r.pos : t, b != t)
                                return r = e.extend(r, C(b, g, !0)), !1
                        } else if (r !== !0 && void 0 != r.pos && r.pos != t && (b = r.pos, _(t, b), b != t))
                            return r = e.extend(r, C(b, g, !0)), !1;
                        return 1 != r && void 0 == r.pos && void 0 == r.c ? !1 : (s > 0 && d(!0), v(b, e.extend({}, l, {input: P(g, u)}), n) || (r = !1), !1)
                    }
                }), r
            }
            function s(t, i, a, n) {
                var r, s, l = e.extend(!0, {}, c().validPositions);
                for (r = p(); r >= 0; r--)
                    if (c().validPositions[r] && void 0 != c().validPositions[r].alternation) {
                        s = c().validPositions[r].alternation;
                        break
                    }
                if (void 0 != s)
                    for (var u in c().validPositions)
                        if (parseInt(u) > parseInt(r) && void 0 === c().validPositions[u].alternation) {
                            for (var v = c().validPositions[u], f = v.locator[s], m = c().validPositions[r].locator[s].split(","), h = 0; h < m.length; h++)
                                if (f < m[h]) {
                                    for (var k, g, b = u - 1; b >= 0; b--)
                                        if (k = c().validPositions[b], void 0 != k) {
                                            g = k.locator[s], k.locator[s] = m[h];
                                            break
                                        }
                                    if (f != k.locator[s]) {
                                        for (var _ = y().slice(), P = u; P < p() + 1; P++)
                                            delete c().validPositions[P], delete c().tests[P];
                                        d(!0), o.keepStatic = !o.keepStatic;
                                        for (var P = u; P < _.length; P++)
                                            _[P] != o.skipOptionalPartCharacter && C(p() + 1, _[P], !1, !0);
                                        k.locator[s] = g;
                                        var E = C(t, i, a, n);
                                        if (o.keepStatic = !o.keepStatic, E)
                                            return E;
                                        d(), c().validPositions = e.extend(!0, {}, l)
                                    }
                                }
                            break
                        }
                return!1
            }
            function l(t, i) {
                for (var a = c().validPositions[i], n = a.locator, o = n.length, r = t; i > r; r++)
                    if (!x(r)) {
                        var s = g(r), l = s[0], u = -1;
                        e.each(s, function(e, t) {
                            for (var i = 0; o > i; i++)
                                t.locator[i] && E(t.locator[i].toString().split(","), n[i].toString().split(",")) && i > u && (u = i, l = t)
                        }), v(r, e.extend({}, l, {input: l.match.def}), !0)
                    }
            }
            a = a === !0;
            for (var u = y(), m = t - 1; m > - 1 && !c().validPositions[m]; m--)
                ;
            for (m++; t > m; m++)
                void 0 == c().validPositions[m] && ((!x(m) || u[m] != j(m)) && g(m).length > 1 || u[m] == o.radixPoint || "0" == u[m] && e.inArray(o.radixPoint, u) < m) && r(m, u[m], !0);
            var h = t, k = !1, b = e.extend(!0, {}, c().validPositions);
            if (h < M() && (k = r(h, i, a, n), !a && k === !1)) {
                var w = c().validPositions[h];
                if (!w || null != w.match.fn || w.match.def != i && i != o.skipOptionalPartCharacter) {
                    if ((o.insertMode || void 0 == c().validPositions[A(h)]) && !x(h))
                        for (var O = h + 1, T = A(h); T >= O; O++)
                            if (k = r(O, i, a, n), k !== !1) {
                                l(h, O), h = O;
                                break
                            }
                } else
                    k = {caret: A(h)}
            }
            if (k === !1 && o.keepStatic && R(u) && (k = s(t, i, a, n)), k === !0 && (k = {pos: h}), e.isFunction(o.postValidation) && 0 != k && !a) {
                d(!0);
                var G = o.postValidation(y(), o);
                if (!G)
                    return d(!0), c().validPositions = e.extend(!0, {}, b), !1
            }
            return k
        }
        function x(e) {
            var t = h(e);
            return null != t.fn ? t.fn : !1
        }
        function M() {
            var e;
            at = it.prop("maxLength"), -1 == at && (at = void 0);
            var t, i = p(), a = c().validPositions[i], n = void 0 != a ? a.locator.slice() : void 0;
            for (t = i + 1; void 0 == a || null != a.match.fn || null == a.match.fn && "" != a.match.def; t++)
                a = m(t, n, t - 1), n = a.locator.slice();
            return e = t, void 0 == at || at > e ? e : at
        }
        function A(e) {
            var t = M();
            if (e >= t)
                return t;
            for (var i = e; ++i < t && !x(i) && (o.nojumps !== !0 || o.nojumpsThreshold > i); )
                ;
            return i
        }
        function w(e) {
            var t = e;
            if (0 >= t)
                return 0;
            for (; --t > 0 && !x(t); )
                ;
            return t
        }
        function S(e) {
            return void 0 == c().validPositions[e] ? j(e) : c().validPositions[e].input
        }
        function O(t, i, a, n, r) {
            if (n && e.isFunction(o.onBeforeWrite)) {
                var s = o.onBeforeWrite.call(t, n, i, a, o);
                if (s) {
                    if (s.refreshFromBuffer) {
                        var l = s.refreshFromBuffer;
                        _(l === !0 ? l : l.start, l.end, s.buffer), d(!0), i = y()
                    }
                    a = s.caret || a
                }
            }
            t._valueSet(i.join("")), void 0 != a && B(t, a), r === !0 && (rt = !0, e(t).trigger("input"))
        }
        function j(e, t) {
            return t = t || h(e), void 0 != t.placeholder ? t.placeholder : null == t.fn ? t.def : o.placeholder.charAt(e % o.placeholder.length)
        }
        function T(t, i, a, n) {
            function o() {
                var e = !1, t = b().slice(v, A(v)).join("").indexOf(u);
                if (-1 != t && !x(v)) {
                    e = !0;
                    for (var i = b().slice(v, v + t), a = 0; a < i.length; a++)
                        if (" " != i[a]) {
                            e = !1;
                            break
                        }
                }
                return e
            }
            var r = void 0 != n ? n.slice() : t._valueGet().split("");
            d(), c().p = A(-1), i && t._valueSet("");
            var s = b().slice(0, A(-1)).join(""), l = r.join("").match(new RegExp(G(s), "g"));
            l && l.length > 0 && r.splice(0, s.length * l.length);
            var u = "", v = 0;
            e.each(r, function(i, n) {
                var r = e.Event("keypress");
                r.which = n.charCodeAt(0), u += n;
                var s = p(), l = c().validPositions[s], d = m(s + 1, l ? l.locator.slice() : void 0, s);
                if (!o() || a) {
                    var f = a ? i : null == d.match.fn && d.match.optionality && s + 1 < c().p ? s + 1 : c().p;
                    q.call(t, r, !0, !1, a, f), v = f + 1, u = ""
                } else
                    q.call(t, r, !0, !1, !0, s + 1)
            }), i && O(t, y(), e(t).is(":focus") ? A(p(0)) : void 0, e.Event("checkval"))
        }
        function G(t) {
            return e.inputmask.escapeRegex.call(this, t)
        }
        function D(t) {
            if (t.data("_inputmask") && !t.hasClass("hasDatepicker")) {
                var i = [], a = c().validPositions;
                for (var n in a)
                    a[n].match && null != a[n].match.fn && i.push(a[n].input);
                var r = (nt ? i.reverse() : i).join(""), s = (nt ? y().slice().reverse() : y()).join("");
                return e.isFunction(o.onUnMask) && (r = o.onUnMask.call(t, s, r, o) || r), r
            }
            return t[0]._valueGet()
        }
        function F(e) {
            if (nt && "number" == typeof e && (!o.greedy || "" != o.placeholder)) {
                var t = y().length;
                e = t - e
            }
            return e
        }
        function B(t, i, a) {
            var n, r = t.jquery && t.length > 0 ? t[0] : t;
            if ("number" != typeof i)
                return r.setSelectionRange ? (i = r.selectionStart, a = r.selectionEnd) : document.selection && document.selection.createRange && (n = document.selection.createRange(), i = 0 - n.duplicate().moveStart("character", -1e5), a = i + n.text.length), {begin: F(i), end: F(a)};
            if (i = F(i), a = F(a), a = "number" == typeof a ? a : i, e(r).is(":visible")) {
                var s = e(r).css("font-size").replace("px", "") * a;
                r.scrollLeft = s > r.scrollWidth ? s : 0, 0 == o.insertMode && i == a && a++, r.setSelectionRange ? (r.selectionStart = i, r.selectionEnd = a) : r.createTextRange && (n = r.createTextRange(), n.collapse(!0), n.moveEnd("character", a), n.moveStart("character", i), n.select())
            }
        }
        function I(t) {
            var i, a, n = y(), o = n.length, r = p(), s = {}, l = c().validPositions[r], u = void 0 != l ? l.locator.slice() : void 0;
            for (i = r + 1; i < n.length; i++)
                a = m(i, u, i - 1), u = a.locator.slice(), s[i] = e.extend(!0, {}, a);
            var d = l && void 0 != l.alternation ? l.locator[l.alternation].split(",") : [];
            for (i = o - 1; i > r && (a = s[i].match, (a.optionality || a.optionalQuantifier || l && void 0 != l.alternation && void 0 != s[i].locator[l.alternation] && - 1 != e.inArray(s[i].locator[l.alternation].toString(), d)) && n[i] == j(i, a)); i--)
                o--;
            return t ? {l: o, def: s[o] ? s[o].match : void 0} : o
        }
        function K(e) {
            for (var t = I(), i = e.length - 1; i > t && !x(i); i--)
                ;
            e.splice(t, i + 1 - t)
        }
        function R(t) {
            if (e.isFunction(o.isComplete))
                return o.isComplete.call(it, t, o);
            if ("*" == o.repeat)
                return void 0;
            var i = !1, a = I(!0), n = w(a.l), r = p();
            if (r == n && (void 0 == a.def || a.def.newBlockMarker || a.def.optionalQuantifier)) {
                i = !0;
                for (var s = 0; n >= s; s++) {
                    var l = x(s);
                    if (l && (void 0 == t[s] || t[s] == j(s)) || !l && t[s] != j(s)) {
                        i = !1;
                        break
                    }
                }
            }
            return i
        }
        function L(e, t) {
            return nt ? e - t > 1 || e - t == 1 && o.insertMode : t - e > 1 || t - e == 1 && o.insertMode
        }
        function N(t) {
            var i = e._data(t).events;
            e.each(i, function(t, i) {
                e.each(i, function(e, t) {
                    if ("inputmask" == t.namespace && "setvalue" != t.type) {
                        var i = t.handler;
                        t.handler = function(e) {
                            if (!this.disabled && (!this.readOnly || "keydown" == e.type && e.ctrlKey && 67 == e.keyCode)) {
                                switch (e.type) {
                                    case"input":
                                        if (rt === !0)
                                            return rt = !1, e.preventDefault();
                                        break;
                                    case"keydown":
                                        ot = !1;
                                        break;
                                    case"keypress":
                                        if (ot === !0)
                                            return e.preventDefault();
                                        ot = !0;
                                        break;
                                    case"compositionstart":
                                        break;
                                    case"compositionupdate":
                                        rt = !0;
                                        break;
                                    case"compositionend":
                                }
                                return i.apply(this, arguments)
                            }
                            e.preventDefault()
                        }
                    }
                })
            })
        }
        function H(t) {
            function i(t) {
                if (void 0 == e.valHooks[t] || 1 != e.valHooks[t].inputmaskpatch) {
                    var i = e.valHooks[t] && e.valHooks[t].get ? e.valHooks[t].get : function(e) {
                        return e.value
                    }, a = e.valHooks[t] && e.valHooks[t].set ? e.valHooks[t].set : function(e, t) {
                        return e.value = t, e
                    };
                    e.valHooks[t] = {get: function(t) {
                            var a = e(t);
                            if (a.data("_inputmask")) {
                                if (a.data("_inputmask").opts.autoUnmask)
                                    return a.inputmask("unmaskedvalue");
                                var n = i(t), o = a.data("_inputmask"), r = o.maskset, s = r._buffer;
                                return s = s ? s.join("") : "", n != s ? n : ""
                            }
                            return i(t)
                        }, set: function(t, i) {
                            var n, o = e(t), r = o.data("_inputmask");
                            return r ? (n = a(t, e.isFunction(r.opts.onBeforeMask) ? r.opts.onBeforeMask.call(vt, i, r.opts) || i : i), o.triggerHandler("setvalue.inputmask")) : n = a(t, i), n
                        }, inputmaskpatch: !0}
                }
            }
            function a() {
                var t = e(this), i = e(this).data("_inputmask");
                return i ? i.opts.autoUnmask ? t.inputmask("unmaskedvalue") : s.call(this) != b().join("") ? s.call(this) : "" : s.call(this)
            }
            function n(t) {
                var i = e(this).data("_inputmask");
                i ? (l.call(this, e.isFunction(i.opts.onBeforeMask) ? i.opts.onBeforeMask.call(vt, t, i.opts) || t : t), e(this).triggerHandler("setvalue.inputmask")) : l.call(this, t)
            }
            function r(t) {
                e(t).bind("mouseenter.inputmask", function() {
                    var t = e(this), i = this, a = i._valueGet();
                    "" != a && a != y().join("") && (this._valueSet(e.isFunction(o.onBeforeMask) ? o.onBeforeMask.call(vt, a, o) || a : a), t.triggerHandler("setvalue.inputmask"))
                });
                var i = e._data(t).events, a = i.mouseover;
                if (a) {
                    for (var n = a[a.length - 1], r = a.length - 1; r > 0; r--)
                        a[r] = a[r - 1];
                    a[0] = n
                }
            }
            var s, l;
            if (!t._valueGet) {
                if (Object.getOwnPropertyDescriptor) {
                    Object.getOwnPropertyDescriptor(t, "value")
                }
                document.__lookupGetter__ && t.__lookupGetter__("value") ? (s = t.__lookupGetter__("value"), l = t.__lookupSetter__("value"), t.__defineGetter__("value", a), t.__defineSetter__("value", n)) : (s = function() {
                    return t.value
                }, l = function(e) {
                    t.value = e
                }, i(t.type), r(t)), t._valueGet = function(e) {
                    return nt && e !== !0 ? s.call(this).split("").reverse().join("") : s.call(this)
                }, t._valueSet = function(e) {
                    l.call(this, nt ? e.split("").reverse().join("") : e)
                }
            }
        }
        function U(t, i, a, n) {
            function r() {
                if (o.keepStatic) {
                    d(!0);
                    var i, a = [];
                    for (i = p(); i >= 0; i--)
                        if (c().validPositions[i]) {
                            if (void 0 != c().validPositions[i].alternation)
                                break;
                            a.push(c().validPositions[i].input), delete c().validPositions[i]
                        }
                    if (i > 0)
                        for (; a.length > 0; ) {
                            c().p = A(p());
                            var n = e.Event("keypress");
                            n.which = a.pop().charCodeAt(0), q.call(t, n, !0, !1, !1, c().p)
                        }
                }
            }
            if ((o.numericInput || nt) && (i == e.inputmask.keyCode.BACKSPACE ? i = e.inputmask.keyCode.DELETE : i == e.inputmask.keyCode.DELETE && (i = e.inputmask.keyCode.BACKSPACE), nt)) {
                var s = a.end;
                a.end = a.begin, a.begin = s
            }
            if (i == e.inputmask.keyCode.BACKSPACE && (a.end - a.begin < 1 || 0 == o.insertMode) ? a.begin = w(a.begin) : i == e.inputmask.keyCode.DELETE && a.begin == a.end && a.end++, f(a.begin, a.end, !1, n), n !== !0) {
                r();
                var l = p(a.begin);
                l < a.begin ? (-1 == l && d(), c().p = A(l)) : c().p = a.begin
            }
        }
        function W(i) {
            var a = this, n = e(a), r = i.keyCode, l = B(a);
            r == e.inputmask.keyCode.BACKSPACE || r == e.inputmask.keyCode.DELETE || s && 127 == r || i.ctrlKey && 88 == r && !t("cut") ? (i.preventDefault(), 88 == r && (X = y().join("")), U(a, r, l), O(a, y(), c().p, i, X != y().join("")), a._valueGet() == b().join("") ? n.trigger("cleared") : R(y()) === !0 && n.trigger("complete"), o.showTooltip && n.prop("title", c().mask)) : r == e.inputmask.keyCode.END || r == e.inputmask.keyCode.PAGE_DOWN ? setTimeout(function() {
                var e = A(p());
                o.insertMode || e != M() || i.shiftKey || e--, B(a, i.shiftKey ? l.begin : e, e)
            }, 0) : r == e.inputmask.keyCode.HOME && !i.shiftKey || r == e.inputmask.keyCode.PAGE_UP ? B(a, 0, i.shiftKey ? l.begin : 0) : (o.undoOnEscape && r == e.inputmask.keyCode.ESCAPE || 90 == r && i.ctrlKey) && i.altKey !== !0 ? (T(a, !0, !1, X.split("")), n.click()) : r != e.inputmask.keyCode.INSERT || i.shiftKey || i.ctrlKey ? 0 != o.insertMode || i.shiftKey || (r == e.inputmask.keyCode.RIGHT ? setTimeout(function() {
                var e = B(a);
                B(a, e.begin)
            }, 0) : r == e.inputmask.keyCode.LEFT && setTimeout(function() {
                var e = B(a);
                B(a, nt ? e.begin + 1 : e.begin - 1)
            }, 0)) : (o.insertMode = !o.insertMode, B(a, o.insertMode || l.begin != M() ? l.begin : l.begin - 1)), st = -1 != e.inArray(r, o.ignorables)
        }
        function q(t, i, a, n, r) {
            var s = this, l = e(s), u = t.which || t.charCode || t.keyCode;
            if (!(i === !0 || t.ctrlKey && t.altKey) && (t.ctrlKey || t.metaKey || st))
                return!0;
            if (u) {
                46 == u && 0 == t.shiftKey && "," == o.radixPoint && (u = 44);
                var p, f = i ? {begin: r, end: r} : B(s), m = String.fromCharCode(u), h = L(f.begin, f.end);
                h && (c().undoPositions = e.extend(!0, {}, c().validPositions), U(s, e.inputmask.keyCode.DELETE, f, !0), f.begin = c().p, o.insertMode || (o.insertMode = !o.insertMode, v(f.begin, n), o.insertMode = !o.insertMode), h = !o.multi), c().writeOutBuffer = !0;
                var k = nt && !h ? f.end : f.begin, b = C(k, m, n);
                if (b !== !1) {
                    if (b !== !0 && (k = void 0 != b.pos ? b.pos : k, m = void 0 != b.c ? b.c : m), d(!0), void 0 != b.caret)
                        p = b.caret;
                    else {
                        var P = c().validPositions;
                        p = !o.keepStatic && (void 0 != P[k + 1] && g(k + 1, P[k].locator.slice(), k).length > 1 || void 0 != P[k].alternation) ? k + 1 : A(k)
                    }
                    c().p = p
                }
                if (a !== !1) {
                    var E = this;
                    if (setTimeout(function() {
                        o.onKeyValidation.call(E, b, o)
                    }, 0), c().writeOutBuffer && b !== !1) {
                        var x = y();
                        O(s, x, i ? void 0 : o.numericInput ? w(p) : p, t, i !== !0), i !== !0 && setTimeout(function() {
                            R(x) === !0 && l.trigger("complete")
                        }, 0)
                    } else
                        h && (c().buffer = void 0, c().validPositions = c().undoPositions)
                } else
                    h && (c().buffer = void 0, c().validPositions = c().undoPositions);
                if (o.showTooltip && l.prop("title", c().mask), i && e.isFunction(o.onBeforeWrite)) {
                    var M = o.onBeforeWrite.call(this, t, y(), p, o);
                    if (M && M.refreshFromBuffer) {
                        var S = M.refreshFromBuffer;
                        _(S === !0 ? S : S.start, S.end, M.buffer), d(!0), M.caret && (c().p = M.caret)
                    }
                }
                t.preventDefault()
            }
        }
        function V(t) {
            var i = (e(this), t.keyCode, y());
            o.onKeyUp.call(this, t, i, o)
        }
        function Q(t) {
            var i = this, a = e(i), n = i._valueGet(!0), r = B(i);
            if ("propertychange" == t.type && i._valueGet().length <= M())
                return!0;
            if ("paste" == t.type) {
                var s = n.substr(0, r.begin), l = n.substr(r.end, n.length);
                s == b().slice(0, r.begin).join("") && (s = ""), l == b().slice(r.end).join("") && (l = ""), window.clipboardData && window.clipboardData.getData ? n = s + window.clipboardData.getData("Text") + l : t.originalEvent && t.originalEvent.clipboardData && t.originalEvent.clipboardData.getData && (n = s + t.originalEvent.clipboardData.getData("text/plain") + l)
            }
            var u = e.isFunction(o.onBeforePaste) ? o.onBeforePaste.call(i, n, o) || n : n;
            return T(i, !0, !1, nt ? u.split("").reverse() : u.split("")), a.click(), R(y()) === !0 && a.trigger("complete"), !1
        }
        function $(t) {
            var i = this;
            T(i, !0, !1), R(y()) === !0 && e(i).trigger("complete"), t.preventDefault()
        }
        function z(e) {
            var t = this;
            X = y().join(""), ("" == tt || 0 != e.originalEvent.data.indexOf(tt)) && (et = B(t))
        }
        function J(t) {
            var i = this, a = et || B(i);
            0 == t.originalEvent.data.indexOf(tt) && (d(), a = {begin: 0, end: 0});
            var n = t.originalEvent.data;
            B(i, a.begin, a.end);
            for (var r = 0; r < n.length; r++) {
                var s = e.Event("keypress");
                s.which = n.charCodeAt(r), ot = !1, st = !1, q.call(i, s)
            }
            setTimeout(function() {
                var e = c().p;
                O(i, y(), o.numericInput ? w(e) : e)
            }, 0), tt = t.originalEvent.data
        }
        function Z() {
        }
        function Y(t) {
            if (it = e(t), it.is(":input") && i(it.attr("type"))) {
                if (it.data("_inputmask", {maskset: n, opts: o, isRTL: !1}), o.showTooltip && it.prop("title", c().mask), ("rtl" == t.dir || o.rightAlign) && it.css("text-align", "right"), "rtl" == t.dir || o.numericInput) {
                    t.dir = "ltr", it.removeAttr("dir");
                    var a = it.data("_inputmask");
                    a.isRTL = !0, it.data("_inputmask", a), nt = !0
                }
                it.unbind(".inputmask"), it.closest("form").bind("submit", function() {
                    X != y().join("") && it.change(), it[0]._valueGet && it[0]._valueGet() == b().join("") && it[0]._valueSet(""), o.removeMaskOnSubmit && it.inputmask("remove")
                }).bind("reset", function() {
                    setTimeout(function() {
                        it.triggerHandler("setvalue.inputmask")
                    }, 0)
                }), it.bind("mouseenter.inputmask", function() {
                    var t = e(this), i = this;
                    !t.is(":focus") && o.showMaskOnHover && i._valueGet() != y().join("") && O(i, y())
                }).bind("blur.inputmask", function(t) {
                    var i = e(this), a = this;
                    if (i.data("_inputmask")) {
                        var n = a._valueGet(), r = y().slice();
                        lt = !0, X != r.join("") && (i.change(), X = r.join("")), "" != n && (o.clearMaskOnLostFocus && (n == b().join("") ? r = [] : K(r)), R(r) === !1 && (i.trigger("incomplete"), o.clearIncomplete && (d(), r = o.clearMaskOnLostFocus ? [] : b().slice())), O(a, r, void 0, t))
                    }
                }).bind("focus.inputmask", function() {
                    var t = (e(this), this), i = t._valueGet();
                    o.showMaskOnFocus && (!o.showMaskOnHover || o.showMaskOnHover && "" == i) && t._valueGet() != y().join("") && O(t, y(), A(p())), X = y().join("")
                }).bind("mouseleave.inputmask", function() {
                    var t = e(this), i = this;
                    if (o.clearMaskOnLostFocus) {
                        var a = y().slice(), n = i._valueGet();
                        t.is(":focus") || n == t.attr("placeholder") || "" == n || (n == b().join("") ? a = [] : K(a), O(i, a))
                    }
                }).bind("click.inputmask", function() {
                    var t = e(this), i = this;
                    if (t.is(":focus")) {
                        var a = B(i);
                        if (a.begin == a.end)
                            if (o.radixFocus && "" != o.radixPoint && -1 != e.inArray(o.radixPoint, y()) && (lt || y().join("") == b().join("")))
                                B(i, e.inArray(o.radixPoint, y())), lt = !1;
                            else {
                                var n = nt ? F(a.begin) : a.begin, r = A(p(n));
                                r > n ? B(i, x(n) ? n : A(n)) : B(i, r)
                            }
                    }
                }).bind("dblclick.inputmask", function() {
                    var e = this;
                    setTimeout(function() {
                        B(e, 0, A(p()))
                    }, 0)
                }).bind(u + ".inputmask dragdrop.inputmask drop.inputmask", Q).bind("setvalue.inputmask", function() {
                    var e = this;
                    T(e, !0, !1), X = y().join(""), (o.clearMaskOnLostFocus || o.clearIncomplete) && e._valueGet() == b().join("") && e._valueSet("")
                }).bind("cut.inputmask", function(t) {
                    rt = !0;
                    var i = this, a = e(i), n = B(i);
                    U(i, e.inputmask.keyCode.DELETE, n), O(i, y(), c().p, t, X != y().join("")), i._valueGet() == b().join("") && a.trigger("cleared"), o.showTooltip && a.prop("title", c().mask)
                }).bind("complete.inputmask", o.oncomplete).bind("incomplete.inputmask", o.onincomplete).bind("cleared.inputmask", o.oncleared), it.bind("keydown.inputmask", W).bind("keypress.inputmask", q).bind("keyup.inputmask", V), l || it.bind("compositionstart.inputmask", z).bind("compositionupdate.inputmask", J).bind("compositionend.inputmask", Z), "paste" === u && it.bind("input.inputmask", $), H(t);
                var r = e.isFunction(o.onBeforeMask) ? o.onBeforeMask.call(t, t._valueGet(), o) || t._valueGet() : t._valueGet();
                T(t, !0, !1, r.split(""));
                var s = y().slice();
                X = s.join("");
                var v;
                try {
                    v = document.activeElement
                } catch (f) {
                }
                R(s) === !1 && o.clearIncomplete && d(), o.clearMaskOnLostFocus && (s.join("") == b().join("") ? s = [] : K(s)), O(t, s), v === t && B(t, A(p())), N(t)
            }
        }
        var X, et, tt, it, at, nt = !1, ot = !1, rt = !1, st = !1, lt = !0;
        if (void 0 != a)
            switch (a.action) {
                case"isComplete":
                    return it = e(a.el), n = it.data("_inputmask").maskset, o = it.data("_inputmask").opts, R(a.buffer);
                case"unmaskedvalue":
                    return it = a.$input, n = it.data("_inputmask").maskset, o = it.data("_inputmask").opts, nt = a.$input.data("_inputmask").isRTL, D(a.$input);
                case"mask":
                    X = y().join(""), Y(a.el);
                    break;
                case"format":
                    it = e({}), it.data("_inputmask", {maskset: n, opts: o, isRTL: o.numericInput}), o.numericInput && (nt = !0);
                    var ut = (e.isFunction(o.onBeforeMask) ? o.onBeforeMask.call(it, a.value, o) || a.value : a.value).split("");
                    return T(it, !1, !1, nt ? ut.reverse() : ut), e.isFunction(o.onBeforeWrite) && o.onBeforeWrite.call(this, void 0, y(), 0, o), a.metadata ? {value: nt ? y().slice().reverse().join("") : y().join(""), metadata: it.inputmask("getmetadata")} : nt ? y().slice().reverse().join("") : y().join("");
                case"isValid":
                    it = e({}), it.data("_inputmask", {maskset: n, opts: o, isRTL: o.numericInput}), o.numericInput && (nt = !0);
                    var ut = a.value.split("");
                    T(it, !1, !0, nt ? ut.reverse() : ut);
                    for (var ct = y(), dt = I(), pt = ct.length - 1; pt > dt && !x(pt); pt--)
                        ;
                    return ct.splice(dt, pt + 1 - dt), R(ct) && a.value == ct.join("");
                case"getemptymask":
                    return it = e(a.el), n = it.data("_inputmask").maskset, o = it.data("_inputmask").opts, b();
                case"remove":
                    var vt = a.el;
                    it = e(vt), n = it.data("_inputmask").maskset, o = it.data("_inputmask").opts, vt._valueSet(D(it)), it.unbind(".inputmask"), it.removeData("_inputmask");
                    var ft;
                    Object.getOwnPropertyDescriptor && (ft = Object.getOwnPropertyDescriptor(vt, "value")), ft && ft.get ? vt._valueGet && Object.defineProperty(vt, "value", {get: vt._valueGet, set: vt._valueSet}) : document.__lookupGetter__ && vt.__lookupGetter__("value") && vt._valueGet && (vt.__defineGetter__("value", vt._valueGet), vt.__defineSetter__("value", vt._valueSet));
                    try {
                        delete vt._valueGet, delete vt._valueSet
                    } catch (mt) {
                        vt._valueGet = void 0, vt._valueSet = void 0
                    }
                    break;
                case"getmetadata":
                    if (it = e(a.el), n = it.data("_inputmask").maskset, o = it.data("_inputmask").opts, e.isArray(n.metadata)) {
                        for (var ht, kt = p(), gt = kt; gt >= 0; gt--)
                            if (c().validPositions[gt] && void 0 != c().validPositions[gt].alternation) {
                                ht = c().validPositions[gt].alternation;
                                break
                            }
                        return void 0 != ht ? n.metadata[c().validPositions[kt].locator[ht]] : n.metadata[0]
                    }
                    return n.metadata
                }
    }
    if (void 0 === e.fn.inputmask) {
        var r = navigator.userAgent, s = null !== r.match(new RegExp("iphone", "i")), l = (null !== r.match(new RegExp("android.*safari.*", "i")), null !== r.match(new RegExp("android.*chrome.*", "i")), null !== r.match(new RegExp("android.*firefox.*", "i"))), u = (/Kindle/i.test(r) || /Silk/i.test(r) || /KFTT/i.test(r) || /KFOT/i.test(r) || /KFJWA/i.test(r) || /KFJWI/i.test(r) || /KFSOWI/i.test(r) || /KFTHWA/i.test(r) || /KFTHWI/i.test(r) || /KFAPWA/i.test(r) || /KFAPWI/i.test(r), t("paste") ? "paste" : t("input") ? "input" : "propertychange");
        e.inputmask = {defaults: {placeholder: "_", optionalmarker: {start: "[", end: "]"}, quantifiermarker: {start: "{", end: "}"}, groupmarker: {start: "(", end: ")"}, alternatormarker: "|", escapeChar: "\\", mask: null, oncomplete: e.noop, onincomplete: e.noop, oncleared: e.noop, repeat: 0, greedy: !0, autoUnmask: !1, removeMaskOnSubmit: !1, clearMaskOnLostFocus: !0, insertMode: !0, clearIncomplete: !1, aliases: {}, alias: null, onKeyUp: e.noop, onBeforeMask: void 0, onBeforePaste: void 0, onBeforeWrite: void 0, onUnMask: void 0, showMaskOnFocus: !0, showMaskOnHover: !0, onKeyValidation: e.noop, skipOptionalPartCharacter: " ", showTooltip: !1, numericInput: !1, rightAlign: !1, undoOnEscape: !0, radixPoint: "", radixFocus: !1, nojumps: !1, nojumpsThreshold: 0, keepStatic: void 0, definitions: {9: {validator: "[0-9]", cardinality: 1, definitionSymbol: "*"}, a: {validator: "[A-Za-zА-яЁёÀ-ÿµ]", cardinality: 1, definitionSymbol: "*"}, "*": {validator: "[0-9A-Za-zА-яЁёÀ-ÿµ]", cardinality: 1}}, ignorables: [8, 9, 13, 19, 27, 33, 34, 35, 36, 37, 38, 39, 40, 45, 46, 93, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123], isComplete: void 0, canClearPosition: e.noop, postValidation: void 0}, keyCode: {ALT: 18, BACKSPACE: 8, CAPS_LOCK: 20, COMMA: 188, COMMAND: 91, COMMAND_LEFT: 91, COMMAND_RIGHT: 93, CONTROL: 17, DELETE: 46, DOWN: 40, END: 35, ENTER: 13, ESCAPE: 27, HOME: 36, INSERT: 45, LEFT: 37, MENU: 93, NUMPAD_ADD: 107, NUMPAD_DECIMAL: 110, NUMPAD_DIVIDE: 111, NUMPAD_ENTER: 108, NUMPAD_MULTIPLY: 106, NUMPAD_SUBTRACT: 109, PAGE_DOWN: 34, PAGE_UP: 33, PERIOD: 190, RIGHT: 39, SHIFT: 16, SPACE: 32, TAB: 9, UP: 38, WINDOWS: 91}, masksCache: {}, escapeRegex: function(e) {
                var t = ["/", ".", "*", "+", "?", "|", "(", ")", "[", "]", "{", "}", "\\", "$", "^"];
                return e.replace(new RegExp("(\\" + t.join("|\\") + ")", "gim"), "\\$1")
            }, format: function(t, i, r) {
                var s = e.extend(!0, {}, e.inputmask.defaults, i);
                return a(s.alias, i, s), o({action: "format", value: t, metadata: r}, n(s), s)
            }, isValid: function(t, i) {
                var r = e.extend(!0, {}, e.inputmask.defaults, i);
                return a(r.alias, i, r), o({action: "isValid", value: t}, n(r), r)
            }}, e.fn.inputmask = function(t, i) {
            function r(t, i, n) {
                var o = e(t);
                o.data("inputmask-alias") && a(o.data("inputmask-alias"), {}, i);
                for (var r in i) {
                    var s = o.data("inputmask-" + r.toLowerCase());
                    void 0 != s && ("mask" == r && 0 == s.indexOf("[") ? (i[r] = s.replace(/[\s[\]]/g, "").split("','"), i[r][0] = i[r][0].replace("'", ""), i[r][i[r].length - 1] = i[r][i[r].length - 1].replace("'", "")) : i[r] = "boolean" == typeof s ? s : s.toString(), n && (n[r] = i[r]))
                }
                return i
            }
            var s, l = e.extend(!0, {}, e.inputmask.defaults, i);
            if ("string" == typeof t)
                switch (t) {
                    case"mask":
                        return a(l.alias, i, l), s = n(l), void 0 == s ? this : this.each(function() {
                            o({action: "mask", el: this}, e.extend(!0, {}, s), r(this, l))
                        });
                    case"unmaskedvalue":
                        var u = e(this);
                        return u.data("_inputmask") ? o({action: "unmaskedvalue", $input: u}) : u.val();
                    case"remove":
                        return this.each(function() {
                            var t = e(this);
                            t.data("_inputmask") && o({action: "remove", el: this})
                        });
                    case"getemptymask":
                        return this.data("_inputmask") ? o({action: "getemptymask", el: this}) : "";
                    case"hasMaskedValue":
                        return this.data("_inputmask") ? !this.data("_inputmask").opts.autoUnmask : !1;
                    case"isComplete":
                        return this.data("_inputmask") ? o({action: "isComplete", buffer: this[0]._valueGet().split(""), el: this}) : !0;
                    case"getmetadata":
                        return this.data("_inputmask") ? o({action: "getmetadata", el: this}) : void 0;
                    default:
                        return a(l.alias, i, l), a(t, i, l) || (l.mask = t), s = n(l), void 0 == s ? this : this.each(function() {
                            o({action: "mask", el: this}, e.extend(!0, {}, s), r(this, l))
                        })
                }
            else {
                if ("object" == typeof t)
                    return l = e.extend(!0, {}, e.inputmask.defaults, t), a(l.alias, t, l), s = n(l), void 0 == s ? this : this.each(function() {
                        o({action: "mask", el: this}, e.extend(!0, {}, s), r(this, l))
                    });
                if (void 0 == t)
                    return this.each(function() {
                        var t = e(this).attr("data-inputmask");
                        if (t && "" != t)
                            try {
                                t = t.replace(new RegExp("'", "g"), '"');
                                var n = e.parseJSON("{" + t + "}");
                                e.extend(!0, n, i), l = e.extend(!0, {}, e.inputmask.defaults, n), l = r(this, l), a(l.alias, n, l), l.alias = void 0, e(this).inputmask("mask", l)
                            } catch (o) {
                            }
                        if (e(this).attr("data-inputmask-mask") || e(this).attr("data-inputmask-alias")) {
                            l = e.extend(!0, {}, e.inputmask.defaults, {});
                            var s = {};
                            l = r(this, l, s), a(l.alias, s, l), l.alias = void 0, e(this).inputmask("mask", l)
                        }
                    })
            }
        }
    }
    return e.fn.inputmask
}(jQuery);